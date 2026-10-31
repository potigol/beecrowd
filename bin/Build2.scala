import java.io.{PrintWriter, File}

case class Problem(number: Int, name: String, category: String)
case class Category(name: String, problems: List[Problem] = Nil)
case class Competition(name: String, years: List[Year] = Nil)
case class Year(year: Int, rounds: List[Round] = Nil)
case class Round(name: String, problems: List[Problem] = Nil)

object Text {
  def unsolved(p: Problem, showCategory: Boolean = true): String =
    s"- [ ] [${p.number}](${prefix}${p.number}.html) - ${p.name}${if showCategory then s" *${p.category}*" else ""}"

  def solved(p: Problem, showCategory: Boolean = true): String =
    s"- [x] [${p.number}](${prefix}${p.number}.html) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension})${if showCategory then s" *${p.category}*" else ""}"

  val absent: String = "- [ ] ~~xxxx~~"
}

def clean(s: String): String = s.toLowerCase.filter(_.isLetter)

// Checks if a solution file exists for the given problem number
def problemExists(problem: Int, extension: String, path: String = "../src"): Boolean =
  File(s"${path}/${dir(problem)}/${problem}.${extension}").exists

// Folder bucket for a problem number (e.g. 1234 → "1200")
def dir(problem: Int): String = s"${problem / 100 * 100}"

def saveToFile(name: String, title: String, content: String): Unit = {
  File(name).getParentFile.mkdirs()
  val writer = new PrintWriter(name)
  try {
    writer.write(s"# $title\n\n$content")
  } finally {
    writer.close()
  }
}

// Parses a contest file into a map of year → problem numbers
def getContest(file: String): Map[Int, List[Int]] =
  getLines(file).map { line =>
    val parts = line.split(" ")
    val year = parts(0).toInt
    val problems = parts(1).split(",").flatMap { range =>
      val (start, end) = (range.take(4).toInt, range.takeRight(4).toInt)
      start to end
    }.toList
    year -> problems
  }.toMap

def listContest(contest: Map[Int, List[Int]], year: Int, problems: Map[Int, Problem]): String =
  contest.getOrElse(year, Nil).map(problem => line(problems.get(problem))).mkString("\n")

def line(problem: Option[Problem], showCategory: Boolean = true): String = problem match {
  case Some(p) if problemExists(p.number, extension) => Text.solved(p, showCategory)
  case Some(p) => Text.unsolved(p, showCategory)
  case None => Text.absent
}

val config: Map[String, String] = getLines("config.txt").map { line =>
  val Array(key, value) = line.split("=")
  key.trim -> value.trim
}.toMap

val prefix = config("prefix")
val code = config("code")
val extension = config("extension")

// Generates per-folder README files under src/
def listaGeral(paginaFinal: Int, problems: Map[Int, Problem], path: String = "../src/"): Unit = {
  (10 to paginaFinal).foreach { i =>
    val content = (0 to 99).map(j => i * 100 + j).map(p => line(problems.get(p))).mkString("\n")
    val solved = content.split("\\[x\\]").length - 1
    val absent = content.split(" ~~").length - 1
    val total  = content.split("\\[ \\]").length - 1 + solved - absent
    saveToFile(
      s"${path}${dir(i * 100)}/README.md",
      s"Problemas ${dir(i * 100)} ($solved/$total)",
      content
    )
  }
}

// Returns the subset of problems that appear in any of the given contest files.
// Years present in more than one file have their problem lists merged (not overwritten).
def save(problems: Map[Int, Problem], files: String*): Map[Int, Problem] = {
  val contestNumbers = files
    .map(getContest)
    .foldLeft(Map[Int, List[Int]]()) { (acc, m) =>
      m.foldLeft(acc) { case (a, (year, nums)) =>
        a.updated(year, a.getOrElse(year, Nil) ++ nums)
      }
    }
    .values
    .flatten
  (for {
    n <- contestNumbers
    p <- problems.get(n)
  } yield n -> p).toMap
}

// Generates per-category markdown files
def listaCategoria(problems: Map[Int, Problem], path: String = "../categorias/"): Unit = {
  val groupedByCategory = problems.values.toList.groupBy(_.category)
  groupedByCategory.foreach { case (category, problemList) =>
    val (solved, unsolved) = problemList.partition(p => problemExists(p.number, extension))
    val resolvedLines   = solved.map(p => Text.solved(p, showCategory = false)).sorted
    val unresolvedLines = unsolved.map(p => Text.unsolved(p, showCategory = false)).sorted
    val content =
      ("\n\n## Problemas resolvidos\n" :: resolvedLines).mkString("\n") +
      ("\n\n## Problemas não resolvidos\n" :: unresolvedLines).mkString("\n")
    saveToFile(
      s"${path}${clean(category)}.md",
      s"$category (${resolvedLines.size} / ${problemList.size})",
      content
    )
  }
}

// Generates a chronological problem list for a two-phase competition
def duasfases(problems: Map[Int, Problem], c1: String, c2: String, file: String, title: String): Unit = {
  val contest1 = getContest(c1)
  val contest2 = getContest(c2)
  val s = contest2.keys.toList.sorted.reverse.map { year =>
    s"""
       |## ${year}
       |${if contest1.get(year).isDefined then s"""
       |### 1ª Fase
       |
       |${listContest(contest1, year, problems)}""" else ""}
       |
       |### 2ª Fase
       |
       |${listContest(contest2, year, problems)}
       """.stripMargin
  }
  val str    = s.mkString("\n")
  val solved = str.split("\\[x\\]").length - 1
  val total  = str.split("\\[ \\]").length - 1 + solved
  saveToFile(file, s"$title ($solved / $total)", str)
}

// Generates a chronological problem list for a single-phase competition
def umafase(problems: Map[Int, Problem], c1: String, file: String, title: String): Unit = {
  val contest = getContest(c1)
  val s = contest.keys.toList.sorted.reverse.map { year =>
    val entries = contest.getOrElse(year, Nil).map(x => line(problems.get(x))).mkString("\n")
    s"\n\n## $year\n\n$entries"
  }.mkString
  val solved = s.split("\\[x\\]").length - 1
  val total  = s.split("\\[ \\]").length - 1 + solved
  saveToFile(file, s"$title ($solved / $total)", s)
}

def problemList(file: String): Map[Int, Problem] =
  getLines(file).map { line =>
    val x = line.split("\\t")
    Problem(x(0).toInt, x(1), if x.length > 2 then x(2) else "")
  }.map(p => p.number -> p).toMap

def getLines(file: String): Iterator[String] = io.Source.fromFile(file).getLines()

@main def main(): Unit = {
  val problems = problemList("problems.txt")

  // Per-folder lists (src/xx00/README.md)
  listaGeral(40, problems)

  // Per-category lists
  listaCategoria(problems)
  listaCategoria(save(problems, "obi.txt"),                              "../competicoes/obi/")
  listaCategoria(save(problems, "maratona1.txt", "maratona2.txt"),      "../competicoes/maratona/")
  listaCategoria(save(problems, "olip.txt"),                            "../competicoes/outras/olip/")
  listaCategoria(save(problems, "maratona0.txt"),                       "../competicoes/outras/fasezero/")

  // Per-competition chronological lists
  duasfases(problems, "maratona1.txt", "maratona2.txt", "../competicoes/maratona/README.md",         "Maratona de Programação")
  umafase  (problems, "obi.txt",                        "../competicoes/obi/README.md",              "Olimpíada Brasileira de Informática")
  umafase  (problems, "olip.txt",                       "../competicoes/outras/olip/README.md",      "Olimpíada IFSULDEMINAS")
  umafase  (problems, "maratona0.txt",                  "../competicoes/outras/fasezero/README.md",  "Fase Zero - Maratona SBC")
}

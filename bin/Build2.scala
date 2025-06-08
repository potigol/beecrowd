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

// Checks if a file for the problem exists
def problemExists(problem: Int, extension: String, path: String = "../src"): Boolean =
  File(s"${path}/${dir(problem)}/${problem}.${extension}").exists

def dir(problem: Int): String = s"${problem / 100 * 100}"
 
def saveToFile(name: String, title: String, content: String): Unit = {
  val writer = new PrintWriter(name)
  try {
    writer.write(s"# $title\n\n$content")
  } finally {
    writer.close()
  }
}

def getContest(file: String): Map[Int, List[Int]] = {
  getLines(file).map { line =>
    val parts = line.split(" ")
    val year = parts(0).toInt
    val problems = parts(1).split(",").flatMap { range =>
      val (start, end) = (range.take(4).toInt, range.takeRight(4).toInt)
      start to end
    }.toList
    year -> problems
  }.toMap
}

def listContest(contest: Map[Int, List[Int]], year: Int, problems: Map[Int, Problem]): String =
  contest.getOrElse(year, Nil).map(problem => line(problems.get(problem))).mkString("\n")

def formatByCategory(problems: List[Problem], showCategory: Boolean = true): (List[String], List[String]) = {
  val (solved, unsolved) = problems.partition(p => problemExists(p.number, extension))
  (solved.map(p => Text.solved(p, showCategory)).sorted, unsolved.map(p => Text.unsolved(p, showCategory)).sorted)
}

def generateListForCategories(problems: Map[Int, Problem], path: String = "../categories/"): Unit = {
  val groupedByCategory = problems.values.toList.groupBy(_.category)
  groupedByCategory.foreach { case (category, problemList) =>
    val (solved, unsolved) = formatByCategory(problemList, showCategory = false)
    val content = List(
      "## Problemas resolvidos",
      solved.mkString("\n"),
      "## Problemas não resolvidos",
      unsolved.mkString("\n")
    ).mkString("\n\n")
    saveToFile(s"${path}${clean(category)}.md", s"$category (${solved.size} / ${problemList.size})", content)
  }
}

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

def listaGeral(paginaFinal: Int, problems: Map[Int, Problem], path: String = "../src/"): Unit = {
  (10 to paginaFinal).foreach { i =>
    val content = (0 to 99).map(j => i * 100 + j).map(p => line(problems.get(p))).mkString("\n")
    val solved = content.count(_ == 'x')
    val total = content.count(_ == '[') - solved
    saveToFile(s"${path}${dir(i * 100)}/README.md", s"Problemas ${dir(i * 100).replace("-", " a ")} ($solved/$total)", content)
  }
}

@main def main(): Unit = {
  val problems = problemList("problems.txt")
  listaGeral(35, problems)
  generateListForCategories(problems)
}

def problemList(file: String): Map[Int, Problem] = {
  getLines(file).map { line =>
    val Array(number, name, category) = line.split("\\t")
    Problem(number.toInt, name, category)
  }.map(p => p.number -> p).toMap
}

def getLines(file: String): Iterator[String] = io.Source.fromFile(file).getLines()

import java.io.PrintWriter
import java.io.File

case class Problem(number: Int, name: String, category: String)
//  override def toString: String = s"${number}\t${name}\t${category}"

case class Category(name: String):
  var problems: List[Problem] = Nil

case class Competition(name: String):
  var years: List[Year] = Nil

case class Year(year: Int):
  var rounds: List[Round] = Nil

case class Round(name: String):
  var problems: List[Problem] = Nil

object Text:
  def unsolved(p: Problem, showCategory: Boolean = true): String =
    s"- [ ]  [${p.number}](${prefix}${p.number}.html) - ${p.name}${if(showCategory) s" *${p.category}*" else ""}"
  def solved(p: Problem, showCategory: Boolean = true): String =
    s"- [x]  [${p.number}](${prefix}${p.number}.html) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension})${if(showCategory) s" *${p.category}*" else ""}"
  def absent: String = s"- [ ] ~~xxxx~~"

// lowercase letters of a string
def clean(s: String): String = s.toLowerCase.filter(p => p >= 'a' && p <= 'z')

// Checks whether a problem file exists
def exists(extension: String, path: String = "../src")(problem: Int): Boolean =
  File(s"${path}/${dir(problem)}/${problem}.${extension}").exists

// Folder of a problem
def dir(problem: Int): String = s"${problem / 100 * 100}"

// Save the content to a file
def save(name: String, title: String, content: String): Unit = new PrintWriter(name) {
  write(s"# ${title}\n\n${content}")
  close
}

// Get the list of problems
def getContest(file: String): Map[Int, List[Int]] =
  getLines(file).map { a =>
    val b = a.split(" ")
    val c = b(1).split(",")
    val d = for c1 <- c
                c2 <- c1.take(4).toInt to c1.takeRight(4).toInt
            yield c2
    b(0).toInt -> d.toList
  }.toMap

def listContest(contest: Map[Int, List[Int]], year: Int, problems: Map[Int, Problem]): String = {
  for x <- contest(year) yield line(problems.get(x))
}.mkString("\n")

// Generates a problem list for a two phases competition
def duasfases(problems: Map[Int, Problem], c1: String, c2: String, file: String, title: String): Unit =
  val contest1 = getContest(c1)
  val contest2 = getContest(c2)
  val s = for year <- contest2.keys.toList.sorted.reverse yield
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
  val str = s.mkString("\n")
  val solved = str.split("\\[x\\]").length - 1
  val total = str.split("\\[ \\]").length - 1 + solved
  save(file, s"$title ($solved / $total)", str)

// Generates a problem list for a one phase competition
def umafase(problems: Map[Int, Problem], c1: String, file: String, title: String): Unit =
  val contest = getContest(c1)
  var s = ""
  for year <- contest.keys.toList.sorted.reverse do
    s = s + s"\n\n## ${year}\n\n"
    for y <- contest.get(year); x <- y do
      s = s + line(problems.get(x)) + "\n"
  val solved = s.split("\\[x\\]").length - 1
  val total = s.split("\\[ \\]").length - 1 + solved
  save(file, s"$title ($solved / $total)", s)

// One line for each problem
def line(problem: Option[Problem], showCategory: Boolean = true): String = problem match
  case None => Text.absent
  case Some(p) if (exists(extension)(p.number)) => Text.solved(p)
  case Some(p) => Text.unsolved(p)

val config: Map[String, String] = {
  for l <- getLines("config.txt")
      List(a, b) = l.split("=").toList
  yield (a, b)
}.toMap
val prefix = config("prefix")
val code = config("code")
val extension = config("extension")

// Lista Geral
def listaGeral(paginaFinal: Int, problems: Map[Int, Problem], path: String = "../src/"): Unit =
  for i <- 10 to paginaFinal do
    val d = for j <- 0 to 99
                x = i * 100 + j
            yield line(problems.get(x))
    val s = d.mkString("\n")
    val solved = s.split("\\[x\\]").length - 1
    val absent = s.split(" \\~\\~").length - 1
    val total = s.split("\\[ \\]").length - 1 + solved - absent
    save(s"${path}${dir(i*100)}/README.md", s"Problemas ${dir(i*100).replace("-", " a ")} (${solved * 100 / total}%)", s)

// Lista por categoria
def listaCategoria(problems: Map[Int, Problem], path: String = "../categorias/"): Unit =
  val problemsByCategory = problems.values.toList.groupBy(_.category)
  val categories = problemsByCategory.keySet.toList
  for d <- categories do
    val bd = problemsByCategory(d)

    val (f, g) = bd.partition(p => exists(extension)(p.number))
    val resolvidos = f.map {p => Text.solved(p, false)}.sorted
    val naoresolvidos = g.map {p => Text.unsolved(p, false)}.sorted

    val h = ("\n\n## Problemas resolvidos\n" :: resolvidos).mkString("\n") +
            ("\n\n## Problemas não resolvidos\n" :: naoresolvidos).mkString("\n")
    save(s"${path}${clean(d)}.md", s"${d} (${resolvidos.length} / ${bd.length})", h)

def save(problems: Map[Int, Problem], files: String*): Map[Int, Problem] = {
  val contest = files.map(getContest)
                     .foldLeft(Map[Int, List[Int]]())(_ ++ _)
                     .values
                     .flatten
  for n <- contest; p <- problems.get(n) yield (n -> p)
}.toMap

def problemList(file: String): Map[Int, Problem] =
  val problemList1 = getLines(file)
  problemList1.map { a =>
    val x = a.split("\\t")
    Problem(x(0).toInt, x(1), x(2))
  }.map {p => p.number -> p}.toMap

def getLines(file: String) = io.Source.fromFile(file).getLines()

// Principal
@main def main(): Unit =
  val problems: Map[Int, Problem] = problemList("problems.txt")
  val categories: Map[Category, Iterable[Problem]] =
    problems.values.groupBy(_.category).map((a,b) => Category(a) -> b.toList)
  listaGeral(35, problems)
  listaCategoria(problems)
  listaCategoria(save(problems, "obi.txt"), "../competicoes/obi/")
  listaCategoria(save(problems, "maratona1.txt", "maratona2.txt"), "../competicoes/maratona/")
  listaCategoria(save(problems, "olip.txt"), "../competicoes/outras/olip/")
  listaCategoria(save(problems, "maratona0.txt"), "../competicoes/outras/fasezero/")

  // Lista por competição
  duasfases(problems, "maratona1.txt", "maratona2.txt", "../competicoes/maratona/README.md", "Maratona de Programação")
  umafase(problems, "obi.txt", "../competicoes/obi/README.md", "Olimpíada de Informática")
  umafase(problems, "olip.txt", "../competicoes/outras/olip/README.md", "Olimpíada IFSULDEMINAS")
  umafase(problems, "maratona0.txt", "../competicoes/outras/fasezero/README.md", "Fase Zero - Maratona SBC")

import java.io.PrintWriter
import java.io.File

object Build extends App {
  case class Problem(number: Int, name: String, category: String) {
    override def toString = s"${number}\t${name}\t${category}"
  }

  // Returns the letters of the string in lowercase
  def clean(s: String) = s.toLowerCase.filter(p => p >= 'a' && p <= 'z')

  // Checks whether a problem file exists
  def check(problem: Int, extension: String, path: String = "../src") =
    new File(s"${path}/${dir(problem)}/${problem}.${extension}").exists

  // Folder of the problem
  def dir(problem: Int) = s"${problem / 100 * 100}"

  // Save the content to a file
  def save(name: String, title: String, content: String) = new PrintWriter(name) {
    write(s"# ${title}\n\n${content}")
    close
  }

  // Get the list of problems
  def getContest(s: String): Map[Int, List[Int]] = io.Source.fromFile(s).getLines().toList.map {
    case a =>
      val b = a.split(" ")
      val c = b(1).split(",")
      val d = for (c1 <- c; c2 <- c1.take(4).toInt to c1.takeRight(4).toInt) yield { c2 }
      b(0).toInt -> d.toList
  }.toMap

  def listContest(contest: Map[Int, List[Int]], year: Int, problems: Map[Int, Problem]): String = {
    for (x <- contest(year)) yield line(problems.get(x))
  }.mkString("\n")

  // Generates a problem list for a two phases competition
  def duasfases(c1: String, c2: String, file: String, title: String) = {
    val contest1 = getContest(c1)
    val contest2 = getContest(c2)
    val s = for (year <- contest2.keys.toList.sorted.reverse) yield {
      s"""
         |## ${year}
         |${if (contest1.get(year) != None) s"""
         |### 1ª Fase
         |
         |${listContest(contest1, year, problems)}"""}
         |
         |### 2ª Fase
         |
         |${listContest(contest2, year, problems)}
         """.stripMargin
       }
    val str = s.mkString("\n")
    val solved = str.split("[x]").length - 1
    val total = str.split("\\[ \\]").length - 1 + solved
    save(file, s"$title ($solved / $total)", str)
  }

  // Generates a problem list for a one phase competition
  def umafase(c1: String, file: String, title: String) = {
    val contest3 = getContest(c1)
    var s = ""
    for (year <- contest3.keys.toList.sorted.reverse) {
      s = s + s"\n\n## ${year}\n\n"
      for (y <- contest3.get(year); x <- y) {
        s = s + line(problems.get(x)) + "\n"
      }
    }
    val solved = s.split("[x]").length - 1
    val total = s.split("\\[ \\]").length - 1 + solved
    save(file, s"$title ($solved / $total)", s)
  }
  // One line for each problem
  def line(problem: Option[Problem], showCategory: Boolean = true) =
    problem match {
      case None => s"  - [ ] ~~xxxx~~"
      case Some(p) if p.category == "SQL" =>
        s"  - [ ]  ~~${p.number}~~ - *${p.category}*"
      case Some(p) if (check(p.number, extension)) =>
        s"  - [x]  [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension}) *${if(showCategory) p.category else " "}*"
      case Some(p) =>
        s"  - [ ]  [${p.number}](${prefix}/${p.number}) - ${p.name} *${if(showCategory) p.category else " "}*"
    }

  val problemList = io.Source.fromFile("problems.txt").getLines().toList
  val problems: Map[Int, Problem] = problemList.map { a =>
    val x = a.split("\t")
    Problem(x(0).toInt, x(1), x(2))
  }.map {p => p.number -> p}.toMap

  val config = {
    for(l <- io.Source.fromFile("config.txt").getLines();
    List(a,b) = l.split("=").toList) yield (a, b)
  }.toMap
  val prefix = config("prefix")
  val code = config("code")
  val extension = config("extension")

  // Lista Geral
  def listaGeral(paginaFinal: Int, problems: Map[Int, Problem], path: String = "../src/") =
    for (i <- 10 to paginaFinal) {
      val d = for (j <- 0 to 99; x = i * 100 + j) yield line(problems.get(x))
      val s = d.mkString("\n")
      val solved = s.split("\\[x\\]").length - 1
      val total = s.split("\\[ \\]").length - 1 + solved
      save(s"${path}${dir(i*100)}/README.md", s"Problemas ${dir(i*100).replace("-", " a ")} ($solved / $total)", s)
    }

  // Lista por categoria

  def listaCategoria(problems: Map[Int, Problem], path: String = "../categorias/") = {
    val problemsByCategory = problems.values.toList.groupBy(_.category)
    val categories = problemsByCategory.keySet.toList
    for (d <- categories) {
      val bd = problemsByCategory(d)
      var count = 0

      val (f, g) = bd.partition(p => check(p.number, extension))
      val resolvidos = f.map {p =>
        s"  - [x]  [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension})"
      }.sorted

      val naoresolvidos = g.map {p =>
        s"  - [ ]  [${p.number}](${prefix}/${p.number}) - ${p.name}"
      }.sorted

      val h = ("\n\n## Problemas resolvidos\n" :: resolvidos).mkString("\n") +
              ("\n\n## Problemas não resolvidos\n" :: naoresolvidos).mkString("\n")
      save(s"${path}${clean(d)}.md", s"${d} (${resolvidos.length} / ${bd.length})", h)
    }
  }

  // Principal
  listaGeral(32, problems)
  listaCategoria(problems)
  val obi = (for(n <- getContest("obi.txt").values.flatten.toList; p <- problems.get(n)) yield (n -> p)).toMap
  listaCategoria(obi, "../competicoes/obi/")
  val maratona = (for(n <- (getContest("maratona1.txt")++getContest("maratona2.txt")).values.flatten.toList; p <- problems.get(n)) yield (n -> p)).toMap
  listaCategoria(maratona, "../competicoes/maratona/")

  // Lista por competição
  duasfases("maratona1.txt", "maratona2.txt", "../competicoes/maratona/README.md", "Maratona de Programação")
  umafase("obi.txt", "../competicoes/obi/README.md", "Olimpíada de Informática")
}

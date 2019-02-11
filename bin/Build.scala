import java.io.PrintWriter

object Build extends App {
  case class Problem(number: Int, name: String, category: String) {
    override def toString = s"${number}\t${name}\t${category}"
  }

  def clean(s: String) = s.toLowerCase.filter(p => p >= 'a' && p <= 'z')

  def check(n: Int) = new java.io.File(s"../src/${dir(n)}/${n}.poti").exists

  val problems = io.Source.fromFile("problems.txt").getLines.toList
  val a = problems.map { a =>
    val x = a.split("\t")
    Problem(x(0).toInt, x(1), x(2))
  }

  val b = a.groupBy(_.category)
  val c = b.keySet
  val prefix =  "https://www.urionlinejudge.com.br/judge/pt/problems/view"
  val code = "https://github.com/potigol/URI-Potigol/blob/master/src"
  def dir(n: Int) = s"${n / 100 * 100 + 1}-${(n / 100 + 1) * 100}"

  // Lista Geral
  for (i <- 10 to 29) {
    val d = for (j <- 1 to 100; x = i * 100 + j) yield {
      a.find(_.number == x) match {
        case None => s"  - [ ] ~~${x}] ~"
        case Some(p) if p.category == "SQL" =>
          s"  - [ ] ~~${p.number}~~ - *${p.category}*"
        case Some(p) if (check(x)) =>
          s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.poti) *${p.category}*"
        case Some(p) =>
          s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name} *${p.category}*"
      }
    }
    import java.io.PrintWriter
    new PrintWriter(s"../src/${dir(i*100+1)}/README.md") {
      write("# Problemas " + s"${dir(i*100+1).replace("-", " a ")}" + "\n\n" + d.mkString("\n"))
      close
    }
  }

  // Lista por categoria
  for (d <- c) {
    val bd = b(d) //.sortBy(_.number)
    var count = 0

    val f = bd.map {
      case p if check(p.number) =>
        count = count + 1
        s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.poti)"
      case p =>
        s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name}"
    }.sorted
    import java.io.PrintWriter
    new PrintWriter("../" + clean(d) + ".md") {
      write(s"# ${d} (${count} / ${bd.length})\n\n${f.mkString("\n")}")
      close
    }
  }

  def getContest(s: String) = io.Source.fromFile(s).getLines.toList.map {
    case a =>
      val b = a.split(" ")
      val c = b(1).split(",")
      val d = for (c1 <- c; c2 <- c1.take(4).toInt to c1.takeRight(4).toInt) yield { c2 }
      b(0).toInt -> d.toList
  }.toMap

  // Lista por competição

  val contest1 = getContest("maratona1.txt")
  val contest2 = getContest("maratona2.txt")
  var s = ""
  for (year <- contest2.keys.toList.sorted.reverse) {
    s = s + s"\n\n## ${year}\n\n"
    s = s + s"\n\n### Final\n\n"
    for (y <- contest2.get(year); x <- y) {
      val pi = a.find(_.number == x)
      s = s + (pi match {
        case None => s"  - [ ] ~~${x}~~ \n"
        case Some(p) if (check(x)) =>
          s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.poti) *${p.category}*\n"
        case Some(p) =>
          s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name} *${p.category}*\n"
      })
    }
    if (contest1.get(year)!= None){
    s = s + s"\n\n### Regional\n\n"
    for (y <- contest1.get(year); x <- y) {
      val pi = a.find(_.number == x)
      s = s + (pi match {
        case None => s"  - [ ] ~~${x}~~ \n"
        case Some(p) if (check(x)) =>
        s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](src/${dir(p.number)}/${p.number}.poti) *${p.category}*\n"
        case Some(p) =>
          s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name} *${p.category}*\n"
      })
    }
    }
  }
  new PrintWriter("../maratona.md") {
    write("# Maratona de Programação\n\n" + s)
    close
  }
}

object Build extends App {
  case class Problem(number: Int, name: String, category: String) {
    override def toString = s"${number}\t${name}\t${category}"
  }

  def clean(s: String) = s.toLowerCase.filter(p => p >= 'a' && p <= 'z')

  def check(n: Int) = {
    val begin = n / 100 * 100 + 1
    val end = begin + 99
    new java.io.File(s"../src/${begin}-${end}/${n}.poti").exists
  }

  val problems = io.Source.fromFile("problems.txt").getLines.toList
  val a = problems.map { a =>
    val x = a.split("\t")
    Problem(x(0).toInt, x(1), x(2))
  }

  val b = a.groupBy(_.category)
  val c = b.keySet

  // Lista Geral
  for (i <- 10 to 29) {
    val d = for (j <- 1 to 100) yield {
      val x = i * 100 + j
      val p = a.find(_.number == x)
      p match {
        case None => s"  - [ ] ~~${x}] ~"
        case Some(p) if p.category == "SQL" =>
          s"  - [ ] ~~${p.number}~~ - *${p.category}*"

        case Some(p) if (check(x)) =>
          s"  - [x] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - [${p.name}](https://github.com/potigol/URI-Potigol/blob/master/src/${p.number / 100 * 100 + 1}-${(p.number / 100 + 1) * 100}/${p.number}.poti) *${p.category}*"
        case Some(p) =>
          s"  - [ ] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - ${p.name} *${p.category}*"
      }
    }
    import java.io.PrintWriter
    new PrintWriter(s"../src/${i * 100 + 1}-${i * 100 + 100}/README.md") {
      write("# Problemas " + s"${i * 100 + 1} a ${i * 100 + 100}" + "\n\n" + d.mkString("\n"))
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
        s"  - [x] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - [${p.name}](https://github.com/potigol/URI-Potigol/blob/master/src/${p.number / 100 * 100 + 1}-${(p.number / 100 + 1) * 100}/${p.number}.poti)"
      case p =>
        s"  - [ ] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - ${p.name}"
    }.sorted
    import java.io.PrintWriter
    new PrintWriter("../" + clean(d) + ".md") {
      write("# " + d + s" (${count} / ${bd.length})\n\n" + f.mkString("\n"))
      close
    }
  }

  // Lista por competição

  val contest1 = io.Source.fromFile("maratona1.txt").getLines.toList.map {
    case a =>
      val b = a.split(" ")
      val c = b(1).split(",")
      val d = for (c1 <- c; c2 <- c1.take(4).toInt to c1.takeRight(4).toInt) yield { c2 }
      b(0).toInt -> d.toList
  }.toMap
  val contest2 = io.Source.fromFile("maratona2.txt").getLines.toList.map {
    case a =>
      val b = a.split(" ")
      val c = b(1).split(",")
      val d = for (c1 <- c; c2 <- c1.take(4).toInt to c1.takeRight(4).toInt) yield { c2 }
      b(0).toInt -> d.toList
  }.toMap
  var s = ""
  for (year <- 2018 to 2002 by -1) {
    s = s + s"\n\n## ${year}\n\n"
    s = s + s"\n\n### Final\n\n"
    for (y <- contest2.get(year); x <- y) {
      val pi = a.find(_.number == x)
      s = s + (pi match {
        case None => s"  - [ ] ~~${x}~~ \n"
        case Some(p) if (check(x)) =>
          s"  - [x] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - [${p.name}](https://github.com/potigol/URI-Potigol/blob/master/src/${p.number / 100 * 100 + 1}-${(p.number / 100 + 1) * 100}/${p.number}.poti) *${p.category}*\n"
        case Some(p) =>
          s"  - [ ] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - ${p.name} *${p.category}*\n"
      })
    }
    if (contest1.get(year)!= None){
    s = s + s"\n\n### Regional\n\n"
    for (y <- contest1.get(year); x <- y) {
      val pi = a.find(_.number == x)
      s = s + (pi match {
        case None => s"  - [ ] ~~${x}~~ \n"
        case Some(p) if (check(x)) =>
        s"  - [x] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - [${p.name}](src/${p.number / 100 * 100 + 1}-${(p.number / 100 + 1) * 100}/${p.number}.poti) *${p.category}*\n"
        case Some(p) =>
          s"  - [ ] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - ${p.name} *${p.category}*\n"
      })
    }
    }
  }
  import java.io.PrintWriter
  new PrintWriter("../maratona.md") {
    write("# Maratona de Programação\n\n" + s)
    close
  }
}

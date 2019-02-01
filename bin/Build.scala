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

  for (i <- 10 to 29) {
    val d = for (j <- 1 to 100) yield {
      val x = i * 100 + j
      val p = a.find(_.number == x)
      p match {
        case None => s"  - [ ] ~${x}~"
        case p if (check(x)) =>
          s"  - [x] [${p.get.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.get.number}) - [${p.get.name}](${p.get.number}.poti)"
        case p =>
        s"  - [ ] [${p.get.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.get.number}) - ${p.get.name}"
      }
    }
    import java.io.PrintWriter
    new PrintWriter(s"../src/${i * 100 + 1}-${i * 100 + 100}/README.md") {
      write("# " + s"${i * 100 + 1}-${i * 100 + 100}" + "\n\n" + d.mkString("\n"))
      close
    }
  }
  for (d <- c) {
    val bd = b(d).sortBy(_.number)
    val f = bd.map {
      case p if check(p.number) =>
        s"  - [x] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - [${p.name}](src/${p.number * 100 + 1}-${p.number * 100 + 100}${p.number}.poti)"
      case p =>
        s"  - [ ] [${p.number}](https://www.urionlinejudge.com.br/judge/pt/problems/view/${p.number}) - ${p.name}"
    }
    import java.io.PrintWriter
    new PrintWriter("../" + clean(d) + ".md") {
      write("# " + d + "\n\n" + f.mkString("\n"))
      close
    }
  }
}

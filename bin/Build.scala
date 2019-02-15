import java.io.PrintWriter

object Build extends App {
  case class Problem(number: Int, name: String, category: String) {
    override def toString = s"${number}\t${name}\t${category}"
  }

  def clean(s: String) = s.toLowerCase.filter(p => p >= 'a' && p <= 'z')

  def check(n: Int) = new java.io.File(s"../src/${dir(n)}/${n}.${extension}").exists

  val problems = io.Source.fromFile("problems.txt").getLines.toList
  val a = problems.map { a =>
    val x = a.split("\t")
    Problem(x(0).toInt, x(1), x(2))
  }

  val b = a.groupBy(_.category)
  val c = b.keySet
  val config = (for(l<-io.Source.fromFile("config.txt").getLines; List(a,b)=l.split("=").toList) yield (a,b)).toMap
  val prefix = config("prefix")
  val code = config("code")
  val extension = config("extension")

  def dir(n: Int) = s"${n / 100 * 100 + 1}-${(n / 100 + 1) * 100}"

  def line(x: Int, cat: Boolean = true) = a.find(_.number == x) match {
    case None => s"  - [ ] ~~${x}~~"
    case Some(p) if p.category == "SQL" =>
      s"  - [ ] ~~${p.number}~~ - *${p.category}*"
    case Some(p) if (check(x)) =>
      s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension}) *${if(cat) p.category else " "}*"
    case Some(p) =>
            s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name} *${if(cat) p.category else " "}*"
  }

  def save(name: String, title: String, content: String) = new PrintWriter(name) {
    write(s"# ${title}\n\n${content}")
    close
  }

  // Lista Geral
  for (i <- 10 to 29) {
    val d = for (j <- 1 to 100; x = i * 100 + j) yield line(x)
    save(s"../src/${dir(i*100+1)}/README.md", s"Problemas ${dir(i*100+1).replace("-", " a ")}", d.mkString("\n"))
  }

  // Lista por categoria
  for (d <- c) {
    val bd = b(d)
    var count = 0

    val f = bd.map {
      case p if check(p.number) =>
        count = count + 1
        s"  - [x] [${p.number}](${prefix}/${p.number}) - [${p.name}](${code}/${dir(p.number)}/${p.number}.${extension})"
      case p =>
        s"  - [ ] [${p.number}](${prefix}/${p.number}) - ${p.name}"
    }.sorted
    save(s"../${clean(d)}.md", s"${d} (${count} / ${bd.length})", f.mkString("\n"))
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
      s = s + line(x) +"\n"
    }
    if (contest1.get(year)!= None){
      s = s + s"\n\n### Regional\n\n"
      for (y <- contest1.get(year); x <- y) {
        s = s + line(x) +"\n"
      }
    }
  }
  save("../maratona.md", "Maratona de Programação", s)

  val contest3 = getContest("obi.txt")
  s = ""
  for (year <- contest3.keys.toList.sorted.reverse) {
    s = s + s"\n\n## ${year}\n\n"
    for (y <- contest3.get(year); x <- y) {
      s = s + line(x) +"\n"
    }
  }
  save("../obi.md", "Olimpiada Brasileira de Informática", s)

}

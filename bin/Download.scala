case class Problem(number: Int, name: String, category: String) {
  override def toString = s"${number}\t${name}\t${category}"
}

object Download extends App {
  def get(page: Int = 1) = {
    val ur = io.Source.fromURL(s"https://www.urionlinejudge.com.br/judge/pt/problems/all?page=${page}").getLines()
    val a = ur.map(_.trim).dropWhile(_ != "<tbody>").drop(1).takeWhile(_ != "</tbody>").filter(_ != "").grouped(13)
    val c = for (b <- a if b.size>7) yield {
      Problem(
        b(2).drop(33).take(4).toInt,
        b(6).drop(39).takeWhile(_ != '<'),
        b(8).drop(37).takeWhile(_ != '<'))
    }
    c
  }
  val all = for (i <- 1 to 76) yield {
    println(i)
    get(i)
  }
  import java.io.PrintWriter
  new PrintWriter("problems.txt") { write(all.reduce(_ ++ _).mkString("\n")); close }
}
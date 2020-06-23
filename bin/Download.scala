import scala.sys.process._

case class Problem(number: Int, name: String, category: String) {
  override def toString = s"${number}\t${name}\t${category}"
}

object Download extends App {
  def get(page: Int = 1) = {
    val ur = Seq("curl", "-sb", "-H", s"https://www.urionlinejudge.com.br/judge/pt/problems/all?page=${page}&limit=100").!!.split("\n")
    val a = ur.map(_.trim).dropWhile(_ != "<tbody>").drop(1).takeWhile(_ != "</tbody>").filter(_ != "").grouped(13)
    val c = for (b <- a if b(1).startsWith("<td class")) yield {
      Problem(
        b(2).drop(33).take(4).toInt,
        b(6).drop(39).takeWhile(_ != '<').trim,
        b(8).drop(37).takeWhile(_ != '<').trim)
    }
    c
  }
  val all = for (i <- 1 to 22) yield {
    println(23-i)
    get(i)
  }
  import java.io.PrintWriter
  new PrintWriter("problems.txt") { write(all.reduce(_ ++ _).mkString("\n")); close }
}

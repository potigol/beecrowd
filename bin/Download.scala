import scala.sys.process._
import scala.util.Try
import java.io.PrintWriter

case class Problem(number: Int, name: String, category: String) {
  override def toString = s"${number}\t${name}\t${category}"
}

object Download extends App {
  def get(page: Int = 1) = {
    val ur = Seq("curl", "-sb", "-H", s"https://www.urionlinejudge.com.br/judge/pt/problems/all?page=${page}&limit=100").!!.split("\n")
    val a = ur.map(_.trim)
              .dropWhile(_ != "<tbody>")
              .tail
              .takeWhile(_ != "</tbody>")
              .filter(_ != "")
              .grouped(15)
    for (b <- a if b(1).startsWith("<td class")) yield {
      val num      = Try {b(2).drop(33).take(4).toInt           }.getOrElse(0)
      val name     = Try {b(6).drop(39).takeWhile(_ != '<').trim}.getOrElse("")
      val category = Try {b(8).drop(37).takeWhile(_ != '<').trim}.getOrElse("")
      Problem(num,name,category)
    }
  }
  val all = (1 to 22).map(get)
  new PrintWriter("problems.txt") {
    write(all.flatten.mkString("\n"))
    close
  }
}

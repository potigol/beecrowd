//import java.io.PrintWriter
//import java.io.File

case class Problem(number: Int, name: String, category: String, solved: Boolean = false)

case class Category(name: String, problems: List[Problem] = Nil)

case class Competition(name: String, years: List[Year] = Nil)

case class Year(year: Int, rounds: List[Round] = Nil)

case class Round(name: String, problems: List[Problem] = Nil)


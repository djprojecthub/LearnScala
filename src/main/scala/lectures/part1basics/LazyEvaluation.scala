package lectures.part1basics

object LazyEvaluation {
  // default
  def strict(n: Int): Unit = {
    println("I am strict")
    println(n)
  }
  def lazy_(n: => Int): Unit = {
    println("I am lazy")
    println(n)
  }
  def main(args: Array[String]): Unit = {
    val add = (a: Int, b: Int) => {
      println("Add")
      a + b
    }
    strict(add(5, 6))
    lazy_(add(5, 6))
  }
}

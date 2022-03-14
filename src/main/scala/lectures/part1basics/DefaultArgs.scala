package lectures.part1basics

object DefaultArgs extends App {

  def trFact (n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  //val fact10 = trFact(10, 1) this pollutes function
  val fact10 = trFact(10)

  // naming parameter helps in using them in any order
}

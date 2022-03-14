package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else{
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  println(factorial(10)) // works fine
  //println(factorial(5000)) // gives stack overflow error

  // tail recursion - function call is the last expression of the function
  def anotherFactorial(n: Int, accumulator: BigInt): BigInt =
    if (n <= 1) accumulator
    else anotherFactorial(n - 1, n * accumulator)
  anotherFactorial(10, 1)

  /*
    anotherFactorial(10, 1)
    anotherFactorial(9, 10 * 1)
    anotherFactorial(8, 10 * 9 * 1)
    .
    .
    .
    anotherFactorial(2, 10 * 9 * 8 * 7 * ... * 2 * 1)
    10 * 9 * 8 * 7 * ... * 2 * 1
   */

  /*
    1.  Concatenate a string n times using tail recursion
    2.  IsPrime function tail recursive
    3.  Fibonacci function tail recursion
   */
    @tailrec
    def concatenateTailrec(aString: String, n: Int, accumulator: String): String = {
      if (n <= 0) accumulator
      else concatenateTailrec(aString, n-1, aString+accumulator)
    }
    println(concatenateTailrec("hello", 3, ""))

    def isPrime(n: Int): Boolean = {
      def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
        if (!isStillPrime) false
        else if (t <= 1) true
        else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
      }
      isPrimeTailrec(n / 2, true)
    }

    println(isPrime(2003))
    println(isPrime(629))

    def fibonacci(n: Int): Int = {
      def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
        if (i >= n) last
        else fiboTailrec(i + 1, last + nextToLast, last)

      if (n <= 2) 1
      else fiboTailrec(2, 1, 1)
    }
    println(fibonacci(8)) // 1 1 2 3 5 8 13 21
}

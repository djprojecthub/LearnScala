package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("hello", 3))
  // compiler can infer return type of a function

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // concatenates same string n times
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // In functional language, when need loops use recursion
  // compiler can't infers return type of recursive function

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  // we need side effects where no computation is need like printing, logging etc.

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }


  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old.
  2. Factorial function 1 * 2 * 3 * 4 * ... * n
  3. A Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n - 2)
  4. Tests if a number is prime.
 */

  def greet(name: String, age: Int) =
    "Hi, my name is " + name + " and I am " + age + " years old."

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }
  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    // does n have any divisors until number t
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
}







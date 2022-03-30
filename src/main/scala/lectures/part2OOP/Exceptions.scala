package lectures.part2OOP

object Exceptions extends App {

  val x: String  = null
  // print(x.length)
  // this will crash with NullPointerException

  // 1. throw exception
  // val aWeirdValue: String = throw new NullPointerException

  // 2. catch exception
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with SOError
    3.  PocketCalculator
        -- add(x, y)
        -- subtract(x, y)
        -- multiply(x, y)
        -- divide(x, y)

        Throw
          -- OverflowException if add(x,y) exceeds Int.MAX_VALUE
          -- UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          -- MathCalculationException for division by 0
   */
  // OutOfMemoryError
  //val array = Array.ofDim(Int.MaxValue)

  // StackOverflowError
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.divide(2, 0))
}

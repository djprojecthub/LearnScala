package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // 1 + 2 is an expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects
  println(aVariable)

  // Instructions vs Expressions

  // IF in scala is an expression not instructions: gives back a value
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF expression
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3) // same as above

  // EVERYTHING in Scala is an Expression!
  // instructions are executed(JAVA)
  // expressions are evaluated(Scala)

  val aWeirdValue = (aVariable = 3)
  // assigning value to a variable is side effect and returns Unit
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // code blocks
  /*
          1.  is an expression
          2.  the value of block is the value of its last expression
       */
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. Difference between "hello world" vs println("hello world")
  /*
        "hello world" - type string literal
        println("hello world") - type Unit
     */
  // 2.

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)


}









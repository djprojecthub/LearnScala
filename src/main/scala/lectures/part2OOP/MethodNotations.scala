package lectures.part2OOP

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // 1. overload + operator(exercise)
    def +(nickname: String): Person = new Person(s"$name the $nickname", favoriteMovie)
    def unary_! : String = s"$name, What the hack?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I Like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent to above
  // infix notation = operator notation (syntactic)

  // "operators" in scala
  val tom = new Person("Tom", "Fight CLub")
  println(mary hangoutWith tom) // hangoutWith acts like a operator
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  //same as
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.

  // prefix notation
  val x = -1    // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1.  Overload the + operator(stringVal)
        -- name + "the rockstar" => new person "Mary the rockstar"

    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns(thing)" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala"
        Use it in postfix notation
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */
  println((mary + "the Rockstar")())  //object.apply()
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))

}

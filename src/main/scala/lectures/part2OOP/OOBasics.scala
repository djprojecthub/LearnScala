package lectures.part2OOP

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age) // only fields can be accessed not parameters
  person.greet("Diwakar")
  person.greet()

  // class parameters are NOT FIELDS
  // add VAR or VAL to make them fields

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  val imposter = new Writer("Charles", "Dickens", 1812)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

  // constructor
  class Person(name: String, val age: Int = 0) {
    // body
    val x = 2

    println(1 + 3)

    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading: same name but different signatures.
      // different signatures means different types or number of parameters
    def greet(): Unit = println(s"Hi, I am $name")
  }

  /*
      Novel and a writer

      Writer: first name, surname, year of birth
        - method fullname: returns concatenated firstname and surname

      Novel: name, year of release, author
      - authorAge: returns age of the author at year of release
      - isWrittenBy(author)
      - copy(new year of release) = new instance of Novel
   */
  class Writer(firstName: String, surname: String, val year: Int) {
    def fullname: String = firstName + " " + surname
  }

  class Novel(name: String, year: Int, author: Writer) {
    def authorAge: Int = year - author.year
    def isWrittenBy(author: Writer) = author == this.author
    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
  }


  /*
      Counter class
        -- receives an int value
        -- method current count
        -- method to inc/dec counter by 1. also, return new counter
        -- overload inc/dec to receive an amount
   */

  class Counter(val count: Int = 0) {
    // immutable instances
    def inc = {
      println("Incrementing")
      new Counter(count + 1)
    }
    def dec = {
      println("decrementing")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
      if(n <= 0) this
      else inc.inc(n-1)
    }
    def dec(n: Int): Counter = {
      if(n<=0) this
      else dec.dec(n-1)
    }
    def print = println(count)
  }
}

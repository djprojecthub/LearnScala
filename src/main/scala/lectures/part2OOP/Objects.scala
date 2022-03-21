package lectures.part2OOP

import com.sun.jnlp.PersistenceServiceNSBImpl

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method: build person instance given some parameter
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS : object Person and class Person

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary1 = Person
    val john1 = Person
    println(mary1 == john1)

    val mary2 = new Person("Mary")
    val john2 = new Person("John")
    println(mary2 == john2)

    val bobbie = Person(mary2, john2)
  }
  // SCALA APPLICATIONS = scala object with
  // def main(args: Array(String)): Unit

}

package lectures.part2OOP

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim==jim2)

  // 4. Case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  print(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case classes are serializable
  // 7. Case classes have extractor pattern = can be used in pattern matching

  case object India {
    def name: String = "I love my India"
  }
}

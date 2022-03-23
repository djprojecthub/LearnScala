package lectures.part2OOP

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")   // public modifier
    // protected def eat = println("nomnom")  // accessible within this class and child class only
    // private def eat = println("nomnom")  //not accesible from child class, only this class
  }

  class Cat extends Animal {
    def crunch = {
      eat
    }
  }

  val cat = new Cat
  //  cat.eat   // accessible only when eat is public
  cat.crunch

  // constructors
    // JVM RULE: call constructor of Person before you call constructor of Adult
  class Person(name: String, age: Int) {
    // auxiliary constructor
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  /*
    --  also works fine because found a auxiliary constructor
    class Adult(name: String, age: Int, idCard: String) extends Person(name)
   */

  // overriding
    // NOTE: we can override fields from super classes directly in constructor
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat = {
      super.eat // calls method of parent class
      println("crunch,crunch")
    }
  }
  //val dog = new Dog
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // will call derived implementation of Animal

  // super - used to refer method or field of parent class

  // preventing override
    // 1 - use keyword final on member
    // 2 - final on class -> no extension
    // 3 - sealed class = extend classes in this file but prevents in other files
}

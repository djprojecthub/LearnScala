package lectures.part2OOP

object AbstractDataTypes extends App {

  // abstract class: class with unimplemented fields or methods
    // purpose: child class will do implementation
  abstract class Animal {
    // non-abstract type
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    // override keyword is optional in case of abstract class
    def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore { // things which eat animal
    def eat(animal: Animal)
    // non-abstract type
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded {

  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = "nomnom"

    override def eat(animal: Animal): Unit = println(s"I am croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
    /*
      1. both can have abstract and non-abstract member
      2. traits do not have constructor parameters
      3. multiple traits can be inherited by the same class(multiple inheritance)
      4. traits are behaviour
     */

}

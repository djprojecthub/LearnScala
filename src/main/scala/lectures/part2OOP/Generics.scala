package lectures.part2OOP

object Generics extends App {

  // MyList is a generic class and A denotes a generic type
  class MyList[+A] {  // Covariant MyList
    // use the type A
    /*
      list of animal which is actually a list of cat. What will happen
      if animalList.add(new Dog) ??? HARD QUESTION
      Theoretical answer: we return list of animals
     */
    // practical implementation
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog = Animal; B is Animal
     */
  }

  // multiple type parameters
  class MyMap[key, value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {   // companion object of class MyList
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // QUESTION: If Cat extends Animal, does list of Cats also extends Animal?
  // 1. YES. List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // but sometimes...
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
    // class Cage only accepts type parameters A which are subtypes of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

}

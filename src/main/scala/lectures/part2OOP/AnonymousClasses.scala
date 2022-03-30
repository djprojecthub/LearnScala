package lectures.part2OOP

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }
  /*
    equivalent with
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass) //class lectures.part2OOP.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println("Hi, my name is $name, how can I help?")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is $name, how can I help?")
  }

  /*
    1. Generic trait MyPredicate[T] with little method test(T) => boolean
    2. Generic trait MyTransformer[A, B]
    3. MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       [1, 2, 3].map(n * 2) = [2, 4, 6]
       [1, 2, 3, 4].filter(n % 2) = [2, 4]
       [1, 2, 3].flatMap(n => [n, n+1]) => [
   */
}

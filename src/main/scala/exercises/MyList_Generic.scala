package exercises

abstract class MyList_Generic[+A] { // Generic and covariant

  /*
    head() = return integer; first element of the list
    tail() = return list; remainder of the list
    isEmpty() = is this List empty
    add(int) => new list with this element added
    toString() => a string representation of the list
   */

  def head: A
  def tail: MyList_Generic[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList_Generic[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList_Generic[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList_Generic[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList_Generic[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

// linked list: an element and rest of the list
class Cons[+A](h: A, t: MyList_Generic[A]) extends MyList_Generic[A] {
  def head: A = h
  def tail: MyList_Generic[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList_Generic[B] = new Cons(element, this)

  override def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val listOfIntegers: MyList_Generic[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList_Generic[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}

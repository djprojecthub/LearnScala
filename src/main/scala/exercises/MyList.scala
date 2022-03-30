//package exercises
//
//abstract class MyList {
//
//  /*
//    head() = return integer; first element of the list
//    tail() = return list; remainder of the list
//    isEmpty() = is this List empty
//    add(int) => new list with this element added
//    toString() => a string representation of the list
//   */
//
//  def head: Int
//  def tail: MyList
//  def isEmpty: Boolean
//  def add(element: Int): MyList
//  def printElements: String
//  // polymorphic call
//  override def toString: String = "[" + printElements + "]"
//}
//
//object Empty extends MyList {
//  def head: Int = throw new NoSuchElementException
//  def tail: MyList = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add(element: Int): MyList = new Cons(element, Empty)
//
//  override def printElements: String = ""
//}
//
//// linked list: an element and rest of the list
//class Cons(h: Int, t: MyList) extends MyList {
//  def head: Int = h
//  def tail: MyList = t
//  def isEmpty: Boolean = false
//  def add(element: Int): MyList = new Cons(element, this)
//
//  override def printElements: String = {
//    if(t.isEmpty) "" + h
//    else h + " " + t.printElements
//  }
//}
//
//object ListTest extends App {
//  // val list = new Cons(1, Empty)
//   val list = new Cons(1, new Cons(2, Empty))
//  //val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.head)
//  // adding an element adds it to head
//  // println(list.add(4).head)
//  println(list.isEmpty)
//
//  println(list.toString)
//}

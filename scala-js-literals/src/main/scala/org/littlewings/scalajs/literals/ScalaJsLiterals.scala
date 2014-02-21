package org.littlewings.scalajs.literals

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global, literal}

object ScalaJsLiterals {
  def main(): Unit = {
    val array = new js.Array[String]
    array(0) = "zero"
    array(1) = "one"
    array(2) = "two"
    array.push("last")

    array.foreach(v => global.console.log(v.toString))  // => zero, one, two, last

    val forSumArray = js.Array(1, 2, 3, 4, 5)
    global.console.log(forSumArray.reduceLeft((acc, i) => acc + i))

    val obj = literal(foo = "bar", num = 3)
    global.console.log(obj.foo)  // => "bar"
    global.console.log(obj.num)  // => 3

    val objNested = literal(topLevel = literal(nextLevel = "bar", num = 3))
    global.console.log(objNested.topLevel.nextLevel)  // => "bar"
    global.console.log(objNested.topLevel.num)  // => 3

    val objHasFunction = literal(func =
                                 (s: String) => global.console.log(s"Hello $s!!"))
    objHasFunction.func("Scala.js")  // => Hello Scala.js!!

    val dic = js.Dictionary(("key1", 1), ("key2", 2))  // "key1" -> 1 だと、うまくいかない
    global.console.log(dic("key1"))  // => 1
    global.console.log(dic("key2"))  // => 2

    class SampleClass(val name: String) {
      def message(pre: String, suf: String): String =
        s"$pre$name$suf"
    }

    val s = new SampleClass("Scala.js")
    global.console.log(s.message("[", "]"))  // => "[Scala.js]"
  }
}

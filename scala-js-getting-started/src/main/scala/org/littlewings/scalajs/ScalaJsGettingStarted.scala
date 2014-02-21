package org.littlewings.scalajs

import scala.scalajs.js
import js.Dynamic.global

object ScalaJsGettingStarted {
  def main(): Unit = {
    val p = global.document.createElement("p")
    p.innerHTML = "<strong>It works!</strong>"
    global.document.getElementById("playground").appendChild(p)
  }
}

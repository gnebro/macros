package com.zibaldone.macros

import org.scalatest.{ Matchers, WordSpec }

class MacrosSpec extends WordSpec with Matchers {

  "Macros" should {
    "print hello when the hello method is invoked" in {
      Macros.hello // should print "hello!"
    }

  }

}

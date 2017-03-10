package com.zibaldone.macros


import scala.language.experimental.macros
import scala.reflect.api.Trees
import scala.reflect.macros.blackbox

object Macros {

  def hello: Unit = macro helloImpl

  def helloImpl(c: blackbox.Context): c.Expr[Unit] = {
    import c.universe._
    c.Expr(q"""println("hello!")""")
  }

  def hello2(s: String) = macro helloImpl2

  def helloImpl2(c: blackbox.Context)(s: c.Expr[String]): c.Expr[Unit] = {
    import c.universe._
    c.Expr(q"""println("hello " + ${s.tree} + "!")""")
  }

}
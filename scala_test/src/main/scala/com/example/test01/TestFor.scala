package com.example.test01

import scala.language.postfixOps

object TestFor {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10 reverse){
      println(i)
    }
  }

}

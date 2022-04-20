package com.example.test01

import scala.io.StdIn

object TestIfElse {
  def main(args: Array[String]): Unit = {
    println("input age")
    var age = StdIn.readInt()

    var res: String = if (age < 20) {
      "teenager"
    } else if (age < 30) {
      "young"
    } else if (age < 40) {
      "middle"
    } else if (age < 50) {
      "old"
    } else {
      "oldest"
    }
    println(res)

    for (i <- 33 to 35) {
      println(i + " ")
    }

    for (i <- 1 to 10 if i % 2 == 0) {
      println(i + " ")
    }

    for (i <- 1 to 10; j <- 1 to 10 if i + j == 12) {
      println(i + " " + j)
    }

    for (i <- 1 to 10; j <- 1 to 10 if i + j == 12; k <- 1 to 10 if i + j + k == 15) {
      println(i + " " + j + " " + k)
    }


  }

}

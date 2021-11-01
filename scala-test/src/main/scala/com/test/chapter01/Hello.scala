package com.test.chapter01

object Hello {
  def main(args: Array[String]): Unit = {
    println("hello scala")

    //注意：这里涉及 自动类型提升，其实编译器可以自定判断是否超出范围，
    //不过 idea 提示 报错
    var c2:Char = 'a' + 1
    println(c2)

    val i:Int = 1.+ (1)

    val j:Int = 1 + (1)

    val k:Int = 1+1

    println(i + "\t" + j + "\t" + k)
    println(1.toString())
    println(1 toString())
    println(1 toString)
  }

}

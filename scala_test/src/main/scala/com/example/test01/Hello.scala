package com.example.test01

/**
 *文档注释
 */
object Hello {
  def main(args: Array[String]): Unit = {
    println(" Hello, world! ")  // Prints " Hello, world! " to the terminal window.
    System.out.println(" Hello, world! ")  // Prints " Hello, world! " to the terminal window.

    /*
    多行
    注释
    */
    println("多行注释")

    //声明变量时类型可以省略
    var age = 18
    age = 30

    var name: String = "张三"
    //类型确定后不能改变
    //age = "18"    //编译错误

    //声明变量必须有初始值
    //var name  //编译错误

    val s =
      """
        |select
        |  name,
        |  age
        |from user
        |where name = 'zhangsan'
        |""".stripMargin

    println(s)
    val s1 =
      """
        |select
        |  name,
        |  age
        |from user
        |where name = '$name' and age = ${age + 2}
        |""".stripMargin

    println(s1)
    val s2 = s"name=$name"
    println(s2)

    val n1: Int = 2.5.toInt

    var str1: String = true + ""
    var str2: String = 4.5 + ""
    var str3: String = 100 + ""

    var s3: String = "12"
    var n2: Byte = s3.toByte
    var n3: Short = s3.toShort
    var n4: Int = s3.toInt
    var n5: Long = s3.toLong
    var n6: Float = s3.toFloat
    var n7: Double = s3.toDouble
    println(n2)
    println(n3)
    println(n4)
    println(n5)
    println(n6)
    println(n7)

    //
    val i:Int = 1.+(1)

    val j:Int = 1 + (1)

    val k:Int = 1 + 1

    println(i)

    println(j)

    println(1.toString())

    println(1 toString())

    println(1 toString)
  }

}

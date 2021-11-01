package com.test.chapter01

object TestFunction {

  def main(args: Array[String]): Unit = {
    //函数标准写法
    def f(s: String): String = {
      return s + "标准写法"
    }

    println(f("hello"))


    //至简原则：能省则省
    //1、 return可以省略，scala会使用函数体的最后一行代码最为返回值
    def f1(s: String): String = {
      s + "省略return"
    }

    println(f1("hello1"))

    //2、如果函数体只有一行代码，可以省略花括号
    def f2(s: String): String = s + "省略花括号"

    println(f2("hello2"))

    //3、返回值类型如果可以推断，可以省略
    def f3(s: String) = s + "省略返回值类型"

    println(f3("hello3"))

    //4、如果有return，不能省略返回值类型
    def f4(): String = {
      return "不能省略返回值类型"
    }

    println(f4())

    //5、如果函数返回unit，函数体中的return不起作用
    def f5(): Unit = {
      return "return不起作用"
    }

    println(f5())

    //6、scala如果期望无返回值类型，可以省略等号
    //无返回值的函数称为过程
    def f6() {
      "过程"
    }

    println(f6())

    //7、如果函数无参，但是声明了参数列表，调用时，小括号可加可不加
    def f7() = "无参函数小括号可加可不加"

    println(f7())

    //8、如果函数无参，而且没有声明参数列表，调用时，小括号必须省略
    def f8() = "无参函数，且无参数列表"

    println(f8)

    //9、如果只关心逻辑处理，函数名（def)可以省略
    def f9 = (x: String) => {
      println("不关心函数名")
    }

    def f10(f: String => Unit) = {
      f("")
    }

    f10(f9)
    println(f10((x: String) => {
      println("函数名可省略")
    }))


  }

}

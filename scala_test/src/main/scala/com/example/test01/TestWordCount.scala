package com.example.test01

object TestWordCount {

  def main(args: Array[String]): Unit = {

    List("hello scala hbase kafka", "hello spark", "hello spark scala", "hello spark scala hbase kafka")
      .flatMap(_.split(" "))
      .groupBy(x => x)
      .map(x => (x._1, x._2.size))
      .toList
      .sortWith(_._2 > _._2)
      .take(3)
      .foreach(println)
  }
}

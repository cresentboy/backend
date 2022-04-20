package com.example.test01

import org.apache.spark.{SparkConf, SparkContext}

class WordCount {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkconf)
    sc.parallelize(List("hello", "world", "hello", "hello", "world"))
      .collect()
      .foreach(println)

    sc.makeRDD(List("hello", "world", "hello", "hello", "world"))
      .collect()
      .foreach(println)



  }
}

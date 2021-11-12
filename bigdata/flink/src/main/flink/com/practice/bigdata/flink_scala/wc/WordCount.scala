package com.practice.bigdata.flink_scala.wc

import org.apache.flink.api.scala._


// 批处理 word count，DataSet API
object WordCount {
  def main(args: Array[String]): Unit = {
    // 创建一个批处理的执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    // 从文件中读取数据
    val inputFilePath: String = "datas/a.txt"
    val inputDataSet: DataSet[String] = env.readTextFile(inputFilePath)

    // 对 DataSet进行转换操作
    val resultDataSet: DataSet[(String, Int)] = inputDataSet
      .flatMap(_.split(" "))    // 把每一行数据打散，分词
      .map( (_, 1) )    // 转换成二元组
      .groupBy(0)    // 把二元组中下标为0的第一个元素，作为key分组
      .sum(1)    // 把当前key中所有的第二个字段sum起来，得到count

    // 打印输出
    resultDataSet.print()
  }
}

package com.practice.bigdata.flink_scala_1.apitest.sinktest

import com.practice.bigdata.flink_scala_1.apitest.SensorReading
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer011, FlinkKafkaProducer011}

import java.util.Properties


object KafkaSinkTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    // 从文件读取数据
//    val inputStream: DataStream[String] = env.readTextFile("D:\\Projects\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt")

    // 从kafka读取数据
    val properties: Properties = new Properties()
    properties.setProperty("bootstrap.servers", "localhost:9092")
    properties.setProperty("group.id", "consumer-group")
    properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.setProperty("auto.offset.reset", "latest")

    val inputStream: DataStream[String] = env.addSource( new FlinkKafkaConsumer011[String]("sensor", new SimpleStringSchema(), properties) )


    // map成样例类类型
    val dataStream: DataStream[String] = inputStream
      .map( data => {
        val dataArray = data.split(",")
        SensorReading( dataArray(0), dataArray(1).toLong, dataArray(2).toDouble ).toString
      } )

    // 直接写入文件
//    dataStream.writeAsText("D:\\Projects\\BigData\\FlinkTutorial\\src\\main\\resources\\out")

//    dataStream.addSink( StreamingFileSink.forRowFormat[String](
//      new Path("D:\\Projects\\BigData\\FlinkTutorial\\src\\main\\resources\\out"),
//      new SimpleStringEncoder[String]("UTF-8")
//    ).build() )

    dataStream.addSink( new FlinkKafkaProducer011[String]("localhost:9092", "sinktest", new SimpleStringSchema()) )

    env.execute("kafka sink test job")
  }
}

package com.bigdata.mapreduce.writablecomparable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class FlowDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //1 获取job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2 关联本Driver类
        job.setJarByClass(FlowDriver.class);

        //3 关联Mapper和Reducer
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        //4 设置Map端输出数据的KV类型
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        //5 设置程序最终输出的KV类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //6 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\hadoop-3.1.0\\inputFlow2"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\hadoop-3.1.0\\comparableOutFlow"));

        //7 提交Job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);


    }
}

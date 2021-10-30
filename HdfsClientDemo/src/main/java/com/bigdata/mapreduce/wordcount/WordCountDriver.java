package com.bigdata.mapreduce.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // 1 获取配置信息以及获取job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 2 关联本Driver程序的jar
        job.setJarByClass(WordCountDriver.class);

        // 3 关联Mapper和Reducer的jar
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 如果不设置InputFormat，它默认用的是TextInputFormat.class
        job.setInputFormatClass(CombineTextInputFormat.class);

//虚拟存储切片最大值设置4m   运行如果为3个切片 number of splits:3
        CombineTextInputFormat.setMaxInputSplitSize(job, 4194304);

        //虚拟存储切片最大值设置20m   运行如果为1个切片
        //number of splits:1
       // CombineTextInputFormat.setMaxInputSplitSize(job, 20971520);


        // 4 设置Mapper输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 设置最终输出kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 6 设置输入和输出路径
        //注意导包
//        FileInputFormat.setInputPaths(job,new Path("D:\\hadoop-3.1.0\\wcinput"));
        FileInputFormat.setInputPaths(job,new Path(args[0]));
//        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoop-3.1.0\\output"));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // 7 提交job
        boolean result = job.waitForCompletion(true);
        System.out.println(result ? 0 : 1);
    }
}

package org.dedunu.hadoop.hadoop_mapper_only;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperOnly extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        /*
            Here you can add your logic to your Mapper task. For example
            if you only want to filter out line which contains "Hello".
            Below commented code snippet would work.

            String valueString = value.toString();
            if (valueString.contains("Hello")) {
                context.write(value, null);
            }

            You can use this kind of jobs just to add a text to every line.
            Below commented code snippet would add "something" to the end of
            every line.

            String valueString = value.toString();
            context.write(new Text(valueString + "something"),null);

         */
    }

}

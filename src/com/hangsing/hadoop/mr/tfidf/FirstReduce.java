package com.hangsing.hadoop.mr.tfidf;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * c1_001,2 c2_001,1 count,10000
 * 
 * @author root
 *
 */
public class FirstReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

	protected void reduce(Text key, Iterable<IntWritable> iterable,
			Context context) throws IOException, InterruptedException {

		int sum = 0;
		for (IntWritable i : iterable) {
			sum = sum + i.get();
		}
		context.write(key, new IntWritable(sum));
	}
}

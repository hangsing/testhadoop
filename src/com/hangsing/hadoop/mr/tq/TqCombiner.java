package com.hangsing.hadoop.mr.tq;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TqCombiner   extends  Reducer<TQ, Text, TQ, Text>{
	
	@Override
	protected void reduce(TQ key, Iterable<Text> vals, Context context)
			throws IOException, InterruptedException {
		int flg=0;
		int day=0;
		for (Text v : vals) {
			if(flg==0){
				day=key.getDay();	
				context.write(key,v );
				flg++;
			}
			if(flg!=0 && day != key.getDay()){
				context.write(key,v );
				break;
			}
		}
	}
}

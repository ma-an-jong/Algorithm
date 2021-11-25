package 융프하기싫어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회의실_배정 {

	static class Confer implements Comparable<Confer>
	{
		int start;
		int end;
		
		public Confer(int s,int e)
		{
			start = s;
			end =e ;
		}
		
		public int compareTo(Confer o)
		{
			if(this.end == o.end)
				return this.start - o.start;
			else
				return  this.end - o.end;
		}
		
		
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Confer conf[] = new Confer[n];
		String str[];
		
		for(int i = 0 ; i < n; i++)
		{
			
			str= br.readLine().split(" ");
			
			conf[i] = new Confer(Integer.parseInt(str[0]),Integer.parseInt(str[1]));	
		}

		Arrays.sort(conf);

		int count = 1;
		Confer c = conf[0];
		for(int i = 1 ; i < n ; i ++) {
			if(conf[i].start >= c.end)
			{
				c =  conf[i];
				count++;
			}
		}
		
		System.out.println(count);
	
				
	}
}
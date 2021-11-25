package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class ÁÂÇ¥_¾ÐÃà {
	static class Pair implements Comparable<Pair>{
		
		int value;
		int index;
		int result = 0;
		
		public Pair(int v,int i)
		{
			value = v;
			index = i;
		}
		
		@Override
		public int compareTo(Pair o) {
			return value - o.value;
		}
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		String str[] = br.readLine().split(" ");
		Pair data[] = new Pair[n];
		
		for(int i = 0 ; i < n; i++) 
		{
			data[i] = new Pair(Integer.parseInt(str[i]), i);
		}
		
		Arrays.sort(data);
		
		for(int i = 1 ; i < n;i++)
		{
			if(data[i].value > data[i-1].value)
			{
				data[i].result = data[i-1].result+1;
			}
			else
			{
				data[i].result = data[i-1].result;
			}
			
		}
		
		Arrays.sort(data,new Comparator<Pair>() {
			
			public int compare(Pair o1,Pair o2) {
				return o1.index - o2.index;
			}
		});
		
		for(int i = 0 ; i < n ; i++)
		{
			bw.write(data[i].result + " ");
		}
		
		bw.flush();
		
		
	}
}

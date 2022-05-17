package Success;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class 시리얼_번호 {
	public static class Serial implements Comparable<Serial>{
		String s;
		int size;
		
		Serial(String s)
		{
			this.s = s;
			size = s.length();
		}
		
		public int compareTo(Serial o)
		{
			
			if(this.size == o.size) 
			{
				int thisSum = 0;
				for(int i = 0; i < this.size;i++)
				{
					char c = this.s.charAt(i);
					if(c >= '1' && c <= '9')
					{
						thisSum += c - '0';
					}
				}
				
				int oSum = 0;
				for(int i = 0 ; i < o.size;i++)
				{
					char c = o.s.charAt(i);
					if(c >= '1' && c <= '9')
					{
						oSum += c - '0';
					}
				}
				
				if(thisSum == oSum)
				{
					return this.s.compareTo(o.s);
				}
				else 
				{
					return thisSum - oSum;
				}
			}
			else
			{
				return this.size-o.size;
			}
			
		}
		
		
		
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Serial arr[] = new Serial[N];
		
		for(int i = 0 ; i < N ; i++)
		{
			String str  = br.readLine();
			arr[i] = new Serial(str);
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < N; i++)
		{
			sb.append(arr[i].s);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}

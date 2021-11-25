package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Z {
	static long sum = 0;
	
	public static void foo(int N,int r,int c)
	{
		if(N <= 2) {
			if(r == 0&& c == 0) 
			{
				
			}
			else if(r == 1 && c == 0)
			{
				sum += 2;
			}
			else if(r == 0 && c== 1)
			{
				sum += 1;
			}
			else
			{
				sum += 3;
			}
			
			return;
		}
		
		boolean left = c >= N/2 ? false : true;
		boolean up = r >= N/2 ? false : true;
		
		long value = (int)Math.pow(N/2,2);
		
		if(left&&up)
		{
			
		}
		else if(!left&&up)
		{
			sum += value; 
			c -= (N/2);
		}
		else if(left&&!up)
		{
			sum += value*2;
			r -= (N/2);
		}
		else
		{
			sum += value*3;
			r -= (N/2);
			c -= (N/2);
		}
		
		
		foo(N/2,r,c);
		
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);
		int c= Integer.parseInt(str[2]);
		
		foo((int)Math.pow(2,N),r,c);
	
		System.out.println(sum);
		
	}

}

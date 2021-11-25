package ю╤гаго╠Б╫х╬Н;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ╟Ж╪ю {
	static long a;
	static long b;
	static long c;
	
	public static long foo(int n) 
	{
		if(n == 1)
		{
			return a%c;
		}
		else if(n == 0)
		{
			return 1;
		}
		
		if(n%2 == 0)
		{
			long v = foo(n/2);
			return (v*v)%c;
		}
		else
		{
			return ( (foo(n/2) *  foo((n/2)+1)) ) % c;
		}
	}
	
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 String str[] = br.readLine().split(" ");
		 
		  a = Integer.parseInt(str[0]);
		  b = Integer.parseInt(str[1]);
		  c = Integer.parseInt(str[2]);
		  
		  System.out.println(foo((int)b));
		  
	}
}

package Success;

import java.util.Scanner;

public class A»≠ªÏ«•B {
	
	static int func(long A,long B,int count)
	{
		if(A == B) return count;
		
		long left = A*2;
		long right = A*10 + 1;
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		if(left <= B ) a= func(left,B,count+1);
		if(right<= B) b= func(right,B,count+1);
		
		return Math.min(a, b);
		
	}
	
	public static void main(String args[]) throws Exception{
		
		Scanner s = new Scanner(System.in);
		
		int A = s.nextInt();
		int B = s.nextInt();
		int count = 0;
		
		int result = func(A,B,count);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result+1);
		
	}
}

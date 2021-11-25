package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Á¤¼ö_»ï°¢Çü {
	static int memo[][];
	static int data[][];
	static int n;
	
	public static int foo(int x,int y) {
		
		if(x== 0 && y ==0) return data[0][0];
		
		if(x < 0 || y < 0) return Integer.MIN_VALUE; 
		
		if(memo[y][x] == 0)
		{
			memo[y][x] = Math.max(foo(x,y-1),foo(x-1,y-1)) + data[y][x];
			return memo[y][x];
		}
		else
		{
			return memo[y][x];
		}
		
	}
	
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		 memo = new int[n][n];
		data = new int[n][n];
		String str[];
		
		for(int i = 0 ; i < n ; i ++) 
		{
			str = br.readLine().split(" ");
			
			for(int k = 0 ; k < str.length;k++) {
				data[i][k] = Integer.parseInt(str[k]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < n ; i++)
		{
			max = Math.max(foo(i,n-1),max);
		}
		
		System.out.println(max);
		
	}

}




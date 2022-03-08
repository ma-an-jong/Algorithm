package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ½ºÆ¼Ä¿ {
	
	public static int foo(int row,int col) {
		
		if(row > 1 || row < 0 || col < 0 || col >= n) return 0;
		
		if(memo[row][col] == Integer.MIN_VALUE) 
		{
			int a = Math.max(foo(row - 1,col - 1), foo(row + 1, col - 1)) + table[row][col];
			int b = Math.max(Math.max(foo(row - 1,col - 2), foo(row + 1, col - 2)),foo(row,col -2)) + table[row][col];
			memo[row][col] = Math.max(a,b);
		}
		
		return memo[row][col];

		
	}
	
	static int n;
	static int table[][];
	static int memo[][];
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < tc; t++)
		{
			 n = Integer.parseInt(br.readLine());
			
			table = new int[2][n];
			memo = new int[2][n];
			String str[];
			
			for(int i = 0 ; i < 2; i++)
			{
				str = br.readLine().split(" ");
				for(int j = 0 ;j < n;j++) {
					table[i][j] = Integer.parseInt(str[j]); 
					memo[i][j] = Integer.MIN_VALUE;
				}
			}
			
			int a = Math.max(foo(1,n-1), foo(0,n-1));
			
			bw.write(a+"\n");
	
			
			
		}
		
		bw.flush();
		
	}
}

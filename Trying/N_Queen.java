package Trying;

import java.util.Scanner;

public class N_Queen {
	static int N;
	static int dx[] = {0,1,0,-1,	1,-1,1,-1};
	static int dy[] = {1,0,-1,0,	1,1,-1,-1};
	static int count = 0;
	
	static boolean put(boolean table[][])
	{
		for(int i = 0 ;i < N ; i++)
		{
			
		}
		return false;
	}
	
	public static void main(String args[]) throws Exception{
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		boolean table[][] = new boolean[N][N];
		int result= 0;

		System.out.println(result);
		
		
	}
	


}

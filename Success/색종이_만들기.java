package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 색종이_만들기 {
	
	static int white = 0;
	static int blue =0;
	
	public static void foo(char table[][],int x,int y,int N)
	{
		if(N < 1) return;
		
		for(int i = y; i < y+ N; i++)
		{
			for(int j = x; j <x+ N;j++)
			{
				if(table[i][j] != table[y][x])
				{
					foo(table,x			,y		,N/2);
					foo(table,x+(N/2)	,y		,N/2);
					foo(table,x			,y+(N/2),N/2);
					foo(table,x+(N/2)	,y+(N/2),N/2);
					return ;
				}
				
			}
		}
		
		if(table[y][x] == '1') {
			blue++;
		}
		else {
			white++;
		}
		
		
		
		
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char table[][] = new char[N][N];
		String str[];
		
		for(int i = 0 ; i < N ; i++)
		{
			str = br.readLine().split(" ");
			
			for(int j = 0 ; j < N; j++)
			{
				table[i][j] = str[j].charAt(0);
			}
		}
		
		foo(table,0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		
		
		
		
		
	}
}

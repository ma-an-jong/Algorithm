package Algorithm.Fail;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¹ÌÄ£_·Îº¿ {
	
	final static int dx[] = {1, -1 , 0 , 0};
	final static int dy[] = {0 , 0 , 1 ,-1};
	static double percent[] = new double[4];
	static double result = 0.0;
	
	public static void dfs(boolean visited[][],int x,int y,int depth,int n,double sum) {
		
		if(depth > n) {
			result += sum;
			return;
		}
		
		for(int i = 0 ; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(!visited[my][mx]) {
				visited[my][mx] = true;
				dfs(visited, mx, my,depth + 1,n,sum*percent[i]);
				visited[my][mx] = false;
			}
		}
		
	}
	
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		
		for(int i = 1 ; i <= 4;i++) {
			percent[i-1] = Double.parseDouble(str[i])/100;
		}
		
		//ENWS , NWSE , WSEN, SENW , WNES , NESW, ESWN , SWNE
		//EW,WE
		//SN,NS
		
		boolean visited[][] = new boolean[2*n+1][2*n+1];
		
		dfs(visited,n,n,0,n,1);
		
		System.out.println(result);
		

	}
}

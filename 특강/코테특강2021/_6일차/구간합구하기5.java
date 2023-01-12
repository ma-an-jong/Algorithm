package D0830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구간합구하기5 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
	
		int table[][] = new int[n][n];
		
		int sum[][] = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n ;i++ ) {
			str = br.readLine().split(" ");
			for(int j = 1; j <=n ;j++) {
				table[i-1][j-1] = Integer.parseInt(str[j-1]);
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + table[i-1][j-1];
			}
		}
	
		for(int i = 0 ; i < m;i++) {
			str = br.readLine().split(" ");
			int y1 = Integer.parseInt(str[0]);
			int x1 = Integer.parseInt(str[1]);
			
			int y2 = Integer.parseInt(str[2]);
			int x2 = Integer.parseInt(str[3]);
			
			int result = sum[y2][x2] - sum[y2][x1-1] - sum[y1 - 1][x2] + sum[y1-1][x1-1];
			
			bw.write(result+"\n");
		}
	
		bw.flush();

	
	}
}

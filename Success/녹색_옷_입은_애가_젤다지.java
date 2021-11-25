package D0908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class ³ì»ö_¿Ê_ÀÔÀº_¾Ö°¡_Á©´ÙÁö {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		while(true) {
		count++;
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) break;

		int dx[] = {1, 0 ,-1 , 0};
		int dy[] = {0, 1 , 0 ,-1};
		
		int table[][] = new int[n][n];
		int sum[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			for(int j = 0 ; j < n ; j++) {
				table[i][j] = Integer.parseInt(str[j]); 
				sum[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(0); qy.add(0);
		sum[0][0] = table[0][0];
		
		while(!qx.isEmpty()) {
			
			int x = qx.remove();
			int y = qy.remove();
			
			for(int i = 0 ; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				try {
				
					if(sum[my][mx] > sum[y][x] + table[my][mx]) {
						sum[my][mx] = sum[y][x] + table[my][mx];
						qx.add(mx); qy.add(my);
					}
					
				}
				catch (Exception e) {
					
				}
			}
			
		}
		
		bw.write("Problem " +count+": " + sum[n-1][n-1] +"\n");
		}
		bw.flush();
	}
}

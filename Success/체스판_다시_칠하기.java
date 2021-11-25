package D0914;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 체스판_다시_칠하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		char table[][] = new char[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			
			for(int j = 0  ; j < M ; j++) {
				
				table[i][j] = s.charAt(j);
				
			}
		}
		
		char data[][] = new char[8][8];		
		int ans = Integer.MAX_VALUE;
		//
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i+j) %2 == 0) {
					data[i][j] = 'B';
				}
				else {
					data[i][j] = 'W';
				}
			}
		}
		
		int count = 0;
		
		for(int h = 0 ; h <= N-8 ; h++) {
			for(int w = 0 ; w <= M -8 ;w++) {
				count = 0;
				
				for(int i = h; i <h + 8;i++) {
					for(int j = w ; j < w+8; j++) {
						if(data[i-h][j-w] != table[i][j]) {
							count++;
						}
					}
				}
				
				ans = Math.min(count,ans);
				
			}
		}
		
		int count2 = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i+j) %2 == 0) {
					data[i][j] = 'W';
				}
				else {
					data[i][j] = 'B';
				}
			}
		}
		
		for(int h = 0 ; h <= N-8 ; h++) {
			for(int w = 0 ; w <= M -8 ;w++) {
				count2 = 0;
				for(int i = h; i <h + 8;i++) {
					for(int j = w ; j < w+8; j++) {
						if(data[i-h][j-w] != table[i][j]) {
							count2++;
						}
					}
				}
				ans = Math.min(count2,ans);
				
			}
		}
		

		System.out.println(ans);
	
		
	}
}

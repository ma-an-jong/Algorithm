package _2ÀÏÂ÷;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B2251 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		boolean visited[][][] = new boolean[a][b][c];
		
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j <b ;j++) {
				for(int k = 0; k < c;k++) {
					visited[i][j][k] = false;
				}
			}
		}
		
		
		
		for(int i = 0; i < 3;i++) {
			for(int j = 0 ; j < 3;j++) {
				if( i == j) continue;
				int arr[] = {a,b,c};
				
				
				arr[j] += arr[i];
				
			}
		}
		
		
		
	}
}

package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B6236 {
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);		
		
		int data[] = new int[n];
 		
		for(int i = 0; i < n;i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		
		int low = 1;
		int high = 10000;
		
		int ans = Integer.MAX_VALUE;
		
		while(low <= high) {
			int mid;
			int cnt = 0;
			int remain = 0;
			for(int i = 0; i < n ; i++) {
				int price = Integer.parseInt(br.readLine());
				
				mid = (low + high)/2;
				
				if(price > remain) {
					
				}
				else if(price <= remain) {
					remain = (mid - price);
					cnt++;
					
				}
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}

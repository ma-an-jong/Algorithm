package D0910;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 랜선_자르기 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		
		int data[] = new int[k];
		
		for(int i = 0; i < k ; i++) {
			data[i] = Integer.parseInt(br.readLine());	
		}
		
		long front = 0;
		long end = Integer.MAX_VALUE;
		
		long max = 0;
		
		while(true) {
			
			if(front > end) break;
			
			int sum = 0;
			long mid = (front+end)/2;
			
			for(int i = 0 ; i < k;  i++) {
				sum += data[i]/mid;
			}
			
			if(sum >= n) {
				
				if(mid > max) {
					max = mid;
				}
				front = mid + 1;
				
			}
			else {
				end = mid -1 ;
			}
		}
		
		System.out.println(max);
	}
}

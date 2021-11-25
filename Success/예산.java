package D0912;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¿¹»ê {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int data[] = new int[n];
		
		int maxv = Integer.MIN_VALUE;
		
		
		String str[] = br.readLine().split(" ");
		
		for(int i = 0 ; i < n ; i++) {
			data[i] = Integer.parseInt(str[i]);
			maxv = Math.max(maxv, data[i]);
		}
		
		
		int depo = Integer.parseInt(br.readLine());
		

		int low = 1;
		int high = maxv;
		
		
		while(true) {	
			
			if(low > high) break;

			int mid = (low + high)/2;
			
			
			int sum = depo;
			
			for(int i = 0 ; i <n ; i++) {
				
				if(mid >= data[i]) {
					sum -= data[i];
				}
				else {
					sum -= mid;
				}
			}
			
			
			if(sum >= 0) {
				low = mid +1;
			}
			else {
				high = mid -1;
			}		
		}
		
		System.out.println(high);
		
	}
}

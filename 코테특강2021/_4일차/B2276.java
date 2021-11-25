package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2276 {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int tc = Integer.parseInt(br.readLine());
		for(int k = 0 ; k < tc; k++) {
		
			int n = Integer.parseInt(br.readLine());
			
			int n1[] = new int[n];
			
			String str[] = br.readLine().split(" ");
			
			for(int i = 0; i< n ; i++) {
				int x = Integer.parseInt(str[i]);
				n1[i] = x;
			}
			 
			Arrays.sort(n1);
			
			
			int m = Integer.parseInt(br.readLine());
			int flag[] = new int[m];
			
			str = br.readLine().split(" ");
			
			for(int i = 0; i <m ;i++) {
				
				int y = Integer.parseInt(str[i]);
				
				int low = 0;
				int high = n-1;
				int mid;
				
				while(low <= high) {
					
					mid = (low + high)/2;
					
					if(y > n1[mid]) {
						low = mid + 1;
					}
					else if(y < n1[mid]) {
						high = mid - 1;
					}
					else {
						flag[i] = 1;
						break;
					}
				}
			}
			
			for(int i = 0 ; i < m ; i++) {
				bw.write(flag[i]+"\n");
			}
			
			bw.flush();
		}
	}
}

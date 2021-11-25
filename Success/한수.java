package D0928;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ÇÑ¼ö {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		if(n == 1000) System.out.println(144);
		
		else if(n > 110){
			
			int cnt = 99;
			
			for(int k = 111; k < n+1 ; k++) {
				int arr[] = {-1,-1,-1};
				

				int mod = 100;
				
				for(int i = 0 ; i < 3 ; i++) {
					arr[i] = (k/mod)%10;
					mod /= 10;
				}
				
				int v1 = arr[1] - arr[0];
				int v2 = arr[2] - arr[1];
				
				
				if(v1 == v2) cnt++;
			
			
			}
			
			System.out.println(cnt);
			
			
		}
		else if(n > 99 && n < 111) {
			System.out.println(99);
		}
		else {
			System.out.println(n);
		}
		
	}
}

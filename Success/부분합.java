package D0912;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ºÎºÐÇÕ {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);
		
		int data[] = new int[N+1];
		int sum[] = new int[N+1];
		
		str = br.readLine().split(" ");
		
		for(int i = 1 ; i <= N ; i++) {
			data[i] = Integer.parseInt(str[i-1]);
		}
		
		for(int i = 1; i <= N; i++) {
			sum[i] = data[i] + sum[i-1];
		}
		
		int left = 1;
		int right = 2;
		
		int min = Integer.MAX_VALUE;
		
		while(true) {
			
			if(left == N+1 || right == N+1) {
				break;
			}
			
			int ans = sum[right] - sum[left-1];
			
			if(ans >= S) {
				
				if(right - left + 1 < min) {
					min = right - left + 1;
				}
				
				left++;
			}
			
			else 
			{
				right++;
			}
			
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else
		{
			System.out.println(min);
		}
	
	}
}

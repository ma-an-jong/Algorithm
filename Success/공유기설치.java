package D0912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		
		int N = Integer.parseInt(str[0]);
		int home[] = new int[N];
		int C = Integer.parseInt(str[1]);
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			home[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, home[i]);
		}
		
		Arrays.sort(home);
		
		int low = 0;
		int high =  home[N-1];
		
		
		while(true) {
			
			if(low > high) break;
			
			int mid = (low + high)/2;
			
			int a = home[0];
			int count = 1;
			
			for(int i = 1 ; i < N ; i++) {
				int gap = home[i] - a;
				
				if(gap >= mid) {
					count++;
					a = home[i];
				}
			}
			
			if(count < C) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}

			
		}
		
		System.out.println(high);
		
		
	}
}

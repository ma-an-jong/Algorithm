package D0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP {
	
	public static int func(int memo[] , int x) {
		
		if(x == 1) return 0;
		
		if(memo[x] != 0) return memo[x];
		
		int result = Integer.MAX_VALUE;
		
		if(x % 3 == 0) {
			int v3 = func(memo, x/3);
			if(v3 < result) {
				result = v3;
			}
		}
		
		if(x % 2 == 0) {
			int v2 = func(memo, x/2);
			if(v2 < result) {
				result = v2;
			}
		}
		
		int v1 = func(memo, x-1);
		
		if(v1 < result) {
			result =v1;
		}
		
		memo[x] = result + 1;
		
		return result + 1;
		
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		int memo[] = new int[x+1];
 		
		int result = func(memo, x);
		
		System.out.println(result);
		
	}
}

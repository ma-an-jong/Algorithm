package D0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2xn≈∏¿œ∏µ2 {
	public static long f(long memo[],int x) {
		if(x == 0) return 0;
		
		if(memo[x] != 0) return memo[x];
		
		long result = (f(memo,x-2) + f(memo,x-1) + f(memo,x-2))%10007;
		
		memo[x] = result;
		
		return result;
	}
	
	
	public static void main(String args[]) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int n = Integer.parseInt(br.readLine());
		
		long memo[] = new long[1001];
	
		memo[1] = 1;
		memo[2] = 3;
		
		
		memo[n] = f(memo, n);
		
		System.out.println(memo[n]);
		
	}
	
}


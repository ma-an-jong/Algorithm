package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 파도반_수열 {
	
	
	public static long memo[] = new long[100];
	
	public static long foo(int N) {
		
		if(memo[N] != 0) return memo[N];
		
		memo[N] = foo(N-5) + foo(N-1);
	
		return memo[N];
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 1;
		memo[3] = 2;
		memo[4] = 2;
		
		for(int t = 0 ; t < tc; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(foo(N-1));
			
		}
		
	}

}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치_수5 {
	
	public static int foo(int N) {
		if(N == 0) {
			return 0; 
		}
		else if(N == 1) {
			return 1;
		}
		else {
			return foo(N-2) + foo(N-1);
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(foo(N));
		
	}

}

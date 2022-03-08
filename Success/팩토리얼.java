package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ÆÑÅä¸®¾ó {
	
	
	public static long foo(int N) {
		if(N <= 1) {
			return 1;
		}
		else {
			return N*foo(N-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(foo(N));

	}

}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Επ»η {
	public static int[] memo;
	
	public static int func(int T[],int P[],int idx) {
		
		if(idx >= T.length) {
			return 0;
		}
		
		
		int a =0;
		
		if(idx + 1 < T.length) {
			if(memo[idx+1] != Integer.MAX_VALUE) {
				a+= memo[idx+1];
			}
			else {
				a+=func(T, P, idx + 1);
			}
			
		}
		else {
			
		}
		
		int b ; 
		
		if(idx + T[idx] <= T.length) {
			b= P[idx];
			try{
				if(memo[idx + T[idx]] != Integer.MAX_VALUE) {
					b+= memo[idx+T[idx]];
				}
				else {
					b+=func(T, P, idx+ T[idx]);
				}
			}
			catch (Exception e) {
				
			}
			
		}
		else {
			b = 0;
		}
		
		
		int result = Math.max(a, b);
		
		return result;
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int T[] = new int[n+1];
		int P[] = new int[n+1];
		memo = new int[n+1];
		
		for(int i = 0 ; i < n+1;i++) {
			memo[i] = Integer.MAX_VALUE;
		}
		
		String[] str;
		for(int i = 1; i <= n ; i++) {
			str = br.readLine().split(" ");
			
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		}
		
		System.out.println(func(T,P,1));

		
	}
}

package D0830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _123¥ı«œ±‚ {
	
	public static int f(int memo[],int x) {
		
		if(x == 0) return 0;
		
		if(memo[x] != 0 ) return memo[x];
		
		int sum = f(memo,x-1) + f(memo,x-2) + f(memo,x-3);
		
		memo[x] = sum;
		
		return sum;
		
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int memo[] = new int[12];
		
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		for(int i = 0 ; i < n;i++) {
			int x = Integer.parseInt(br.readLine());
			
			bw.write(f(memo,x) + "\n");
		}
		
		bw.flush();

		
	}
}

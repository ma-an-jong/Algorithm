package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치함수 {	
	
	public static int count(int memo[],int i,int zero[],int one[]) {

		if(i == 0) {
			zero[i] = 1;
			return 0;
		}
		
		else if(i == 1) {
			one[i] = 1;
			return 1;
		}
		
		if(memo[i] != 0) {
			zero[i] = zero[i-1]+zero[i-2];
			one[i] = one[i-1]+one[i-2];
			return memo[i];
		}
		
		else {
			memo[i] = count(memo, i-1, zero, one) + count(memo, i-2, zero, one);
			zero[i] = zero[i-1]+zero[i-2];
			one[i] = one[i-1]+one[i-2];
			return memo[i];
		}		
		
		
	}
	
	
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T;i++) {
			int a = Integer.parseInt(br.readLine());
			int memo[] = new int[a+1];
			int zero[] = new int[a+1];
			int one[] = new int[a+1];
			
			
			count(memo,a,zero,one);
			
			
			bw.write(zero[a] + " " + one[a]+"\n");
			
		}
		
		
		bw.flush();		
	}

}

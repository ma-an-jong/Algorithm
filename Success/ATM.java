package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int data[] = new int[n];
		String str[] = br.readLine().split(" ");
		
		for(int i = 0 ; i < n;i++) {
			data[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(data);
		int sum = 0;
		
		for(int i = 0; i < n ; i++) {
			sum += (n-i)*data[i];
		}
		
		System.out.println(sum);

		
	}
}

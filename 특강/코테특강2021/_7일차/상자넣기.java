package D0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상자넣기 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		int data[] = new int[n];
		int sorted[] = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			int x= Integer.parseInt(str[i]);
			data[i] = x;
			sorted[i] = x; 
		}
	
		Arrays.sort(sorted);
		
		for(int i = 0 ; i < data.length;i++) {
		
			int start = 0;
			
			for(int j = 0 ; j < sorted.length;j++) {
				if(sorted[j] == data[i]) {
					start = j;
				}
			}
			
			for(int j = start ; j < sorted.length;j++) {
				
			}
			
			
			
		}
		
		
		
	}
}

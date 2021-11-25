package D0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS3 {
	public static void main(String arg[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		int data[][][] = new int[first.length() + 1][second.length() + 1][third.length() + 1];
		
		int max = 0;
		
		for(int i = 1; i <= first.length() ; i++) {
			for(int j = 1; j <= second.length(); j++) {
				for(int k = 1; k <= third.length(); k++) {
					
					if(first.charAt(i-1) == second.charAt(j-1) && second.charAt(j-1) == third.charAt(k -1)) {
						data[i][j][k] = data[i-1][j-1][k-1] + 1;
						if(max < data[i][j][k]) {
							max = data[i][j][k];
							
						}
						
					}
					else {
						data[i][j][k] = Math.max(Math.max(data[i-1][j][k],data[i][j-1][k]),data[i][j][k-1]);
					}
					
				}
			}
		}
		
		System.out.println(max);
		
		
	}
}

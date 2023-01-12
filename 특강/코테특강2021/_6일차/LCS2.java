package D0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS2 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		int table[][] = new int[s1.length() + 1][s2.length() + 1];
		String data[][] = new String[s1.length() + 1][s2.length() + 1];
				
		for(int i = 0 ; i <= s2.length(); i++) {
			data[0][i] = new String();
		}
		
		for(int i = 0 ; i <= s1.length(); i++) {
			data[i][0] = new String();
		}
		
		int max = 0;
		String result = "";
			
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
					data[i][j] = new String(data[i-1][j-1] + s1.charAt(i-1));
					
					if (max < table[i][j]) {
						max = table[i][j];
						result = data[i][j];
					}
					
				} 
				else {
					if(table[i][j - 1] >= table[i - 1][j]) {
						table[i][j] = table[i][j - 1];
						data[i][j] = new String(data[i][j-1]);
					}
					else {
						table[i][j] = table[i - 1][j];
						data[i][j] = new String(data[i-1][j]);
					}
				}
			}
		}

		System.out.println(max);
		System.out.println(result);
		
	}
}

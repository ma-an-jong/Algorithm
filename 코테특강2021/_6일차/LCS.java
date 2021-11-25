package D0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();

		String s2 = br.readLine();

		int table[][] = new int[s1.length() + 1][s2.length() + 1];

		int max = 0;

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
					if (max < table[i][j]) {
						max = table[i][j];
					}
				} else {
					table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
				}
			}

		}
		System.out.println(max);
	}
}

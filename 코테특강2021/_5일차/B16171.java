package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//라이브러리의 소중함을 알게된 문제

public class B16171 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		String target = br.readLine();
		
		str = str.replaceAll("[0-9]","");

		int hk[] = {17,17};
		int hm[] = {2147483647,2147483647};
		int hk4[] = {1,1};
		
		int ans[] = {0,0};
		
			for(int j = 0; j < target.length();j++) {
			 ans[0] *= hk[0];
			 ans[0] += str.charAt(j);
			 ans[0] %= hm[0];
			 hk4[0] *= hk[0];
			 hk4[0] %= hm[0];
			 
			 ans[1] *= hk[1];
			 ans[1] += target.charAt(j);
			 ans[1] %= hm[1];
			 hk4[1] *= hk[1];
			 hk4[1] %= hm[1];
			}
		gadsddf
		for(int j = 1; j <= str.length() - target.length();j++)
		for(int i = 0; i < target.length() ;i++) {
			ans[0] *= hk[0];
			ans[0] -= (str.charAt(j)*hk4[0])%hm[0];
			ans[0] += str.charAt(j);
			ans[0] += hm[0];
			ans[0] %= hm[0];
		}
		
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		
		
		
		
		
		
		
		

	}
}

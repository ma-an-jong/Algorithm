package D0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B1251 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		ArrayList<String> list = new ArrayList<String>();
		
		String s[] = new String[3];
		
		for(int i = 1; i < str.length() ; i++)
			for(int j = i+1; j < str.length() ;j++) {
				
				s[0] = str.substring(0, i);
				StringBuilder sb = new StringBuilder(s[0]);
				s[0] = sb.reverse().toString();
				
				s[1] = str.substring(i, j);
				sb = new StringBuilder(s[1]);
				s[1] = sb.reverse().toString();
				
				s[2] = str.substring(j, str.length());
				sb = new StringBuilder(s[2]);
				s[2] = sb.reverse().toString();
				
				String result = new String();
				for(int k = 0; k < s.length;k++) {
					result += s[k];
				}
				
				list.add(result);
			}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
		
	}
}

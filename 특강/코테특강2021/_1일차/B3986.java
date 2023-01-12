package D0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i = 0 ; i < n ; i++) {
			Stack<Character> s = new Stack<Character>();
			String str = br.readLine();
			s.push(str.charAt(0));
			for(int k = 1 ; k < str.length();k++) {
				if(!s.isEmpty() && s.peek() == str.charAt(k)) {
					s.pop();
				}
				else {
					s.push(str.charAt(k));
				}
			}
			if(s.isEmpty()) cnt++;
		}
		
		System.out.println(cnt);
	}
}

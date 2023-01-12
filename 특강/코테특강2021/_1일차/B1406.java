package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1406 {
	public void L(Stack<Character> s1, Stack<Character> s2) {
		if(!s1.isEmpty())
		s2.push(s1.pop());
	}

	public void D(Stack<Character> s1, Stack<Character> s2) {
		if(!s2.isEmpty())
		s1.push(s2.pop());
	}

	public void B(Stack<Character> s1) {
		if(!s1.isEmpty())
		s1.pop();
	}

	public void P(Stack<Character> s1, char p) {
		s1.push(p);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		B1406 c = new B1406();

		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();

		String s = br.readLine();
		String cnt = br.readLine();
		
		for(int i = 0; i < s.length(); i ++) {
			s1.push(s.charAt(i));
		}
		
		int j = Integer.parseInt(cnt);
		for (int i = 0; i < j ; i++) {

			String input = br.readLine();
			
			if (input.charAt(0) == 'P') {
				c.P(s1, input.charAt(2));
			} 
			else if (input.charAt(0) == 'D') {
				c.D(s1, s2);
			}
			else if (input.charAt(0) == 'L') {
				c.L(s1, s2);
			}
			else if (input.charAt(0) == 'B') {
				c.B(s1);
			}
		}

		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (!s2.isEmpty()) {
			bw.write(s2.pop());
		}
		
		bw.flush();
		bw.close();
		
	}
}
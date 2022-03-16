package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ±ÕÇüÀâÈù_¼¼»ó {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while (!(str = br.readLine()).equals(".")) 
		{
			
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			
			for (int i = 0; i < str.length(); i++) 
			{
				char c = str.charAt(i);

				try {
					char top = stack.peek();

					if (c == '(' || c == '[') {
						stack.push(c);

					} else if ((c == ')' && top == '(') || (c == ']' && top == '[')) {
						stack.pop();
					}
					else if((c == ')' && top == '[') || ( c == ']' && top == '(')) {
						flag = false;
						break;
					}

				} catch (Exception e) {
					if (c == '(' || c == '[') 
					{
						stack.push(c);
					} 
					else if(c == ')' || c == ']')
					{
						flag = false;
						break;
					}
				}
			}
			
			if (!flag || stack.size() != 0) {
				bw.write("no\n");
			} else if (flag && stack.size() == 0) {
				bw.write("yes\n");
			}
			
		}

		bw.flush();

	}

}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 후위_표기식2 {
	
	static String operand = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		String postfix = br.readLine();
		Stack<Double> stack = new Stack<Double>();
		
		for(int i = 0 ; i < N ; i++)
		{	int value = Integer.parseInt(br.readLine());
			map.put(operand.charAt(i),value);
		}
		
		for(int i = 0 ; i < postfix.length();i++)
		{
			char c = postfix.charAt(i);
			int value = map.getOrDefault(c,0);
			
			if(value == 0)
			{
				double v1 = stack.pop();
				double v2 = stack.pop();
				double result = 0;
				
				switch(c)
				{
					case '+' : 
						result = v2 + v1;
						break;
					case '-':
						result = v2 - v1;
						break;
					case '*' :
						result = v2 * v1;
						break;
					case '/' :
						result = v2/v1;
						break;
				}
				
				stack.push(result);
			}
			else
			{
				stack.push((double)value);
			}

		}
		double ans = stack.pop();
		System.out.printf("%.2f",ans);

		
		
		
	}
}

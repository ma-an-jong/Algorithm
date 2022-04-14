package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class 후위_표기식 {

	
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map.put('#', -1);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 3);
		map.put(')', 0);
		
		String operand = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < operand.length();i++)
		{
			set.add(operand.charAt(i));
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		stack.push('#');
		String query = br.readLine();
		
		for(int i = 0; i < query.length();i++)
		{
			char top = stack.peek();
			char now = query.charAt(i);
			
			if(!set.contains(now))
			{
				int topPriority = map.get(top);
				int nowPriority = map.get(now);
				
				if(now == ')')
				{
					while(true)
					{
						if(top == '(')
						{
							stack.pop();
							break;
						}
						else
						{
							sb.append(stack.pop());
							top = stack.peek();
						}
					}
					
					continue;
					
				}
					
				if(top == '(')
				{
					stack.push(now);
				}
				else if(topPriority >= nowPriority)
				{
					sb.append(top);
					stack.pop();
					i--;
					continue;
				}
				else
				{
					stack.push(now);
				}
			}
			else
			{
				sb.append(now);
			}
		}
		
		while(stack.size() > 1)
		{
			sb.append(stack.pop());
		}
		
		
		System.out.println(sb);
		
	}
}

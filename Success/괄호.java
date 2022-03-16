package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class °ýÈ£ {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str;
		
		for(int i = 0 ; i < N ; i++)
		{
			str = br.readLine();
			boolean flag = true;
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int j = 0; j < str.length() ; j++)
			{
				
				char element = str.charAt(j);
				
				try
				{
					char top = stack.peek();
					
					if(top != element)
					{
						stack.pop();
					}
					else
					{
						stack.push(element);
					}
				}
				catch (Exception e) 
				{
					if(element != '(')
					{
						flag = false;
						break;
					}
					else
					{
						stack.push(element);
					}
				}
				
			}
			
			if(!flag || stack.size() != 0) 
			{
				bw.write("NO\n");
			}
			else if(stack.size() == 0)
			{
				bw.write("YES\n");
			}
		
		}
		
		bw.flush();
		
	}

}

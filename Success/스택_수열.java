package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택_수열 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int sequence[] = new int[N];
		
		int next = 1;
		Stack<Integer> stack = new Stack<Integer>();
		boolean flag = true;
		
		for(int i = 0 ; i < N ; i++)
		{
			sequence[i] = Integer.parseInt(br.readLine());
			
		}
		
		StringBuilder log = new StringBuilder();
		
		for(int i = 0 ; i < N ; i++)
		{
			int value;
			
			if(next > sequence[i])
			{
				if(!stack.isEmpty())
				{
					value = stack.peek();
					
					if(value == sequence[i])
					{
						stack.pop();
						log.append("-\n");
					}
					else
					{
						flag = false;
						break;
					}
				}
				else
				{
					flag = false;
					break;
				}
			}
			else if(next <= sequence[i])
			{
				for(; next <= sequence[i];next++)
				{
					stack.push(next);
					log.append("+\n");
				}
				
				stack.pop();
				log.append("-\n");
			}
				

		}
		
		if(flag)
		{
			bw.write(log.toString());
			bw.flush();
		}
		else
		{
			System.out.println("NO\n");
		}
		

	}

}
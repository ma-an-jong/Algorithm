package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Pair{
	int value;
	int index;
	
	public Pair(int v,int i) {
		value = v;
		index = i;
	}
	
}

public class ž {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int tower[] = new int[n+1];
		String str[] = br.readLine().split(" ");
		
		Stack<Pair> stack = new Stack<Pair>();
		Pair pair;
		
		for(int i = 1; i <= n;i++) 
		{
			
			pair = new Pair(Integer.parseInt(str[i-1]),i);
			
			try 
			{
				while(true) 
				{
					if(stack.peek().value <  pair.value)
					{
						stack.pop();
					}
					else
					{
						Pair tmp = stack.peek();
						tower[i] = tmp.index;
						stack.push(pair);
						break;
					}
				}
				
			}
			catch (Exception e) 
			{
				stack.push(pair);
			}
			
		}
		
		for(int j = 1 ; j <= n ; j++) 
		{
			bw.write(tower[j] +" ");
		}
		
		bw.flush();
		
	}
}

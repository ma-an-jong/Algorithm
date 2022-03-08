package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이진_검색_트리 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node
	{
		int value;		
		Node left;
		Node right;
		
		Node(int value)
		{
			this.value = value;
			left = null;
			right = null;
		}
		
		public void setValue(int value)
		{
			
			if(value > this.value)
			{
				if(right == null)
				{
					right = new Node(value);
				}
				else
				{
					right.setValue(value);
				}
				
			}
			else
			{
				if(left == null)
				{
					left = new Node(value);
				}
				else
				{
					left.setValue(value);
				}
			}
		}
		
		public void print() throws IOException
		{
			if(left != null) left.print();
			if(right != null) right.print();
			bw.write(this.value+"\n");
		}
		
	}
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		Node head = new Node(x);
		
		while(true)
		{
			try 
			{
				x = Integer.parseInt(br.readLine());
				head.setValue(x);
			}
			catch (Exception e) 
			{
				break;
			}

		}
		
		head.print();
		bw.flush();
		
	}
}

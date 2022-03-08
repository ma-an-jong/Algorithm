package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class ť {
	static int last = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		String str[];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			str = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				q.add(Integer.parseInt(str[1]));
				last = Integer.parseInt(str[1]);
			}
			else if(str[0].equals("pop")) {
				try 
				{
					bw.write(q.remove()+"\n");
				}
				catch (Exception e) 
				{
					bw.write("-1\n");
				}
			}
			else if(str[0].equals("size")) 
			{
				bw.write(q.size()+"\n");
			}
			else if(str[0].equals("empty")) 
			{
				if(q.isEmpty())
				{
					bw.write("1\n");
				}
				else
				{
					bw.write("0\n");
				}
			}
			else if(str[0].equals("front")) {
				if(q.isEmpty())
				{
					bw.write("-1\n");
				}
				else
				{
					bw.write(q.peek()+"\n");
				}
			}
			else if(str[0].equals("back")) {
				if(q.isEmpty())
				{
					bw.write("-1\n");
				}
				else
				{
					bw.write(last+"\n");
				}
			}
			
		}
		
		bw.flush();

	}
}
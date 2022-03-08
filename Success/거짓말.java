package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class °ÅÁþ¸» {
	
	static class Party{
		
		List<Integer> party;
		boolean disable; 
		
		Party()
		{
			party = new ArrayList<Integer>();
			disable = false;
		}
		
		
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		
		int know[] = new int[Integer.parseInt(str[0])];
		
		for(int i = 0; i < know.length;i++)
		{
			know[i] = Integer.parseInt(str[i+1]);
		}
		
		ArrayList<Party> list[] = new ArrayList[N+1];
		
		for(int i = 1 ; i <= N ; i++)
		{
			list[i] = new ArrayList<Party>();
		}
		
		int count = M;
		
		for(int i = 0 ; i < M ; i++)
		{
			str = br.readLine().split(" ");
			
			Party p = new Party();
			
			for(int k = 1 ; k < str.length;k++)
			{
				int a = Integer.parseInt(str[k]);
				p.party.add(a);
				list[a].add(p);
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean visited[] = new boolean[N+1];
		
		for(int i =0;i < know.length;i++)
		{
			q.add(know[i]);
		}
		
		while(!q.isEmpty() && count > 0)
		{
			int target = q.remove();
			visited[target] = true;
			
			for(int i = 0; i < list[target].size();i++)
			{
				Party p = list[target].get(i);
				
				if(p.disable) continue;
				
				for(int k = 0; k < p.party.size();k++)
				{
					int t = p.party.get(k);
					if(!visited[t]) q.add(t);
				}
				
				p.disable = true;
				count--;	
			}
		}
		
		
		System.out.println(count);
		
		
		
		
		
		
	}
}

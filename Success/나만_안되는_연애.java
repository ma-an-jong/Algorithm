package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 나만_안되는_연애 {
	static class Edge implements Comparable<Edge>
	{
		int v;
		int adjv;
		int cost;
		
		Edge(int v,int adjv,int cost)
		{
			this.v = v;
			this.adjv = adjv;
			this.cost = cost;
		}
		
		public int compareTo(Edge o)
		{
			return this.cost - o.cost;
		}
		
	}
	
	
	static int find(int p)
	{
		if(vertex[p] == p)
		{
			return p;
		}
		
		vertex[p] = find(vertex[p]);
		
		return vertex[p];
		
	}
	
	static void union(int a , int b)
	{
		int ap = find(a);
		int bp = find(b);
		
		vertex[ap] = bp;

		
	}
	
	static int vertex[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		
		vertex = new int[V+1];
		
		for(int i = 1 ; i <= V ; i++)
		{
			vertex[i] = i;
		}
		
		str = new String[V+1];
		String s[] = br.readLine().split(" ");
		
		for(int i = 1 ; i <=V;i++)
		{
			str[i] = s[i-1];
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 0 ; i < E ; i++)
		{
			String data[] = br.readLine().split(" ");
			
			int v = Integer.parseInt(data[0]);
			int adjv = Integer.parseInt(data[1]);
			int cost = Integer.parseInt(data[2]);
			
			
			if(str[v].equals(str[adjv]))
			{
				continue;
			}
			
			pq.add(new Edge(v,adjv,cost));
			
		}
		
		
		int ans = 0;
		
		for(int i = 0 ; i < V-1;i++)
		{
			
			if(pq.isEmpty())
			{
				System.out.println(-1);
				return;
			}
			
			Edge e = pq.remove();
			
			int vp = find(e.v);
			int adjvp = find(e.adjv);
			
			if(vp != adjvp)
			{
				union(vp, adjvp);
				ans += e.cost;
			}
			else
			{
				i--;
			}
			
		}

		System.out.println(ans);

		
	}

}



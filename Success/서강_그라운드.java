package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 서강_그라운드 {
	
	static class Edge{
		int adjv;
		int distance;
		
		public Edge(int adjv,int distance)
		{
			this.adjv = adjv;
			this.distance = distance;
		}

	}
	
	static class Position implements Comparable<Position>{
		
		int index;
		int distance;
		
		public Position(int index,int distance)
		{
			this.index = index;
			this.distance = distance;
			
		}

		@Override
		public int compareTo(Position o) {
			return distance - o.distance;
		}
		
		
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> list[] = new ArrayList[N+1];
		
		for(int i = 0 ; i < list.length;i++)
		{
			list[i] = new ArrayList<Edge>();
		}
		
		int items[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <=N;i++)
		{
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < r;i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int adjv = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list[v].add(new Edge(adjv,distance));
			list[adjv].add(new Edge(v,distance));

		}
		
		int ans[] = new int[N+1];
		boolean visited[] = new boolean[N+1];

		for(int i = 1; i <= N ; i++)
		{
			PriorityQueue<Position> pq = new PriorityQueue<Position>();
			pq.add(new Position(i,0));

			visited = new boolean[N+1];
			visited[i] = true;
			while(!pq.isEmpty())
			{
				Position position = pq.remove();
				
				for(int j = 0 ; j < list[position.index].size();j++)
				{
					Edge adj = list[position.index].get(j);
					int totalDistance = position.distance + adj.distance;
					
					if(totalDistance <= M)
					{
						visited[adj.adjv] = true;
						pq.add(new Position(adj.adjv,totalDistance));
					}
					
				}
			}
			
			for(int j = 0 ; j < N+1;j++)
			{
				if(visited[j]) ans[i]+= items[j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < ans.length;i++)
		{
			max = Integer.max(max, ans[i]);
		}
		
	System.out.println(max);
		
		
	}
}











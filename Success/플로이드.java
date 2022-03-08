package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 플로이드 {
	static class Edge implements Comparable<Edge>{
		int adjv;
		int cost;
		
		public Edge(int a,int c) {
			adjv = a;
			cost = c;
		}
		
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		int sum;
		
		public Vertex(int v,int s) {
			this.v = v;
			this.sum= s;
		}
		
		public int compareTo(Vertex v) {
			return this.sum - v.sum;
		}
	
	}
	
	//다익스트라 N번 -> 7천만
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Edge> list[] = new ArrayList[n+1];
		
		for(int i = 1 ; i <= n ; i++)
		{
			list[i] = new ArrayList<Edge>();
		}
		
		String str[];
		
		for(int i = 0 ; i < m ; i++)
		{
			str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);
			int adjv = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			list[v].add(new Edge(adjv,cost));
		}
		
		int distance[][] = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n;i++) {
			for(int j = 1; j <= n ; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i <=n ; i++) {
			
			boolean visited[] = new boolean[n+1];
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			visited[i] = true;
			pq.add(new Vertex(i,0));
			
			while(!pq.isEmpty()) {
				Vertex vertex = pq.remove();
				
				visited[vertex.v] = true;
				
				for(int j = 0 ; j < list[vertex.v].size();j++)
				{
					Edge e = list[vertex.v].get(j);
					
					if(visited[e.adjv]) {
						continue;
					}
					
					if(distance[i][e.adjv] >= e.cost + vertex.sum)
					{
						distance[i][e.adjv] = e.cost + vertex.sum;
						pq.add(new Vertex(e.adjv, distance[i][e.adjv]));
					}
				}

			}
				
		}
		
		for(int i = 1 ; i <= n;i++) {
			for(int j = 1; j <= n ; j++) {
				
				if(distance[i][j] == Integer.MAX_VALUE)
					bw.write("0 ");
				else
					bw.write(distance[i][j]+" ");
			}
			bw.write("\n");
		}

		bw.flush();
		
	}

}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	
	int adjv;
	int cost;
	
	public Edge(int adjv,int cost) {
		this.adjv = adjv;
		this.cost = cost;
	}
	
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class 특정한최단경로 {
	
	public static void get(boolean visited[],int distance[],ArrayList<Edge> list[],int start) {
		for(int i = 0 ;i < distance.length;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[distance.length];
		
		distance[start] = 0;

		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		
		q.add(new Edge(start,0));

		while(!q.isEmpty()) {
			Edge e = q.remove();
			
			if(visited[e.adjv] == true) continue;
			
			visited[e.adjv] = true;
			
			for(int i = 0 ; i < list[e.adjv].size();i++) {
				int adjv = list[e.adjv].get(i).adjv;
				int cost = list[e.adjv].get(i).cost;
				
				
				if(!visited[adjv] && distance[adjv] > cost + e.cost) {
					distance[adjv] = cost + e.cost;
					q.add(new Edge(adjv,distance[adjv]));
					
				}
				
				
				
			}
			
			
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		
		ArrayList<Edge> list[] = new ArrayList[n+1];
		
		for(int i = 0 ; i <= n ; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0 ; i < e; i++) {
			str = br.readLine().split(" ");
			
			list[Integer.parseInt(str[0])].add(new Edge(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
			list[Integer.parseInt(str[1])].add(new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[2])));
			
		}
		

		str = br.readLine().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		int distance[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		
		get(visited, distance, list, 1);
		
		int oneToA = distance[a];
		int oneToB = distance[b];
		
		
		get(visited, distance, list, a);
		
		int aToN = distance[n];
		int aToB = distance[b];
		
		get(visited, distance, list, b);
		
		int bToN = distance[n];
		
		int result1 = Integer.MIN_VALUE;
		
		if(oneToA != Integer.MAX_VALUE && aToB != Integer.MAX_VALUE && bToN != Integer.MAX_VALUE) {
			result1 = oneToA+aToB + bToN;
		}
		
		int result2 = Integer.MIN_VALUE;
		
		if(oneToB != Integer.MAX_VALUE && aToB != Integer.MAX_VALUE && aToN != Integer.MAX_VALUE) {
			result2 = oneToB+aToB + aToN;
		}
		
		
		if(result1 == Integer.MIN_VALUE && result1 == Integer.MIN_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(Math.min(result1, result2));
		}

	}

}

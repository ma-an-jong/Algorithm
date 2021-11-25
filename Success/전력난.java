package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	int v;
	int adjv;
	int cost;
	
	Edge(int v,int adjv,int cost){
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}
	
	public int compareTo(Edge o) {
		if(cost > o.cost) {
			return 1;
		}
		else if(cost == o.cost) {
			return 0;
		}
		else 
			return -1;
	}	
}
public class Àü·Â³­ {
	
	public static int find(int[] arr,int a) {
		
		if(arr[a] == a) {
			return arr[a];
		}
		else {
			arr[a] = find(arr,arr[a]);
			return arr[a];
		}
	}
	
	public static void union(int []arr,int a,int b) {
		int ap = find(arr,a); 
		int bp= find(arr,b);
		arr[ap] = bp;
		
	}
	
	
	public static void main(String args[]) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			
			String str[] = br.readLine().split(" ");
			
			int m = Integer.parseInt(str[0]);
			int n = Integer.parseInt(str[1]);
			
			if(m == 0 && n ==0) break;
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			int sum = 0;
			for(int i = 0 ; i < n;i++) {
				str = br.readLine().split(" ");
				
				int v = Integer.parseInt(str[0]);
				int adjv = Integer.parseInt(str[1]);
				int cost = Integer.parseInt(str[2]);
				sum += cost;
				pq.add(new Edge(v, adjv, cost));
			}
			int visited[] = new int[m];
			
			for(int i = 0 ; i < m ; i++) {
				visited[i] = i;
			}
			
			int count = 0;
			
			while(!pq.isEmpty()) {
				Edge e = pq.remove();
				
				if(find(visited,e.v) != find(visited,e.adjv)) {
					count += e.cost;
					union(visited, e.v,e.adjv);
				}
			}
			
			System.out.println(sum - count);	
			
		}
	}
}

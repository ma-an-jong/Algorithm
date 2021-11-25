package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;


//class Edge implements Comparable<Edge>{
//	int v;
//	int w;
//	int cost;
//	
//	public Edge(int v,int w,int cost) {
//		this.v = v;
//		this.w = w;
//		this.cost = cost;
//	}
//	
//	
//	public int compareTo(Edge o) {
//		if(this.cost > o.cost) {
//			return 1;
//		}
//		else if(this.cost == o.cost) {
//			return 0;
//		}
//		else {
//			return -1;
//		}
//	}
//}
//
//
//class Vertex implements Comparable<Vertex>{
//	int v;
//	int sum;
//	
//	public Vertex(int v, int sum) {
//		this.v = v;
//		this.sum = sum;
//	}
//	
//	public int compareTo(Vertex o) {
//		if(this.sum > o.sum) {
//			return 1;
//		}
//		else if(this.sum == o.sum) {
//			return 0;
//		}
//		else {
//			return -1;
//		}
//	}
//}


public class B1753 {
	
	

	
	public static void main(String args[]) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		
		
		int sv = Integer.parseInt(br.readLine());
		
		ArrayList<Edge> list[] = new ArrayList[v+1];
		
		for(int i = 0; i < list.length ; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0 ; i < e ; i++) {
			str = br.readLine().split(" ");
			
			int u = Integer.parseInt(str[0]);
			int c = Integer.parseInt(str[1]);
			
			list[u].add(new Edge(u,c,Integer.parseInt(str[2])));
		
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		int ans[] = new int[v + 1];
		
		for(int i = 0 ; i <= v;i++) 
		{
			ans[i] = Integer.MAX_VALUE;
		}
		
		ans[sv] = 0;
		
		pq.add(new Vertex(sv,0));
		
		while(!pq.isEmpty()) {
			Vertex vertex = pq.remove();
			
			int vsum = vertex.sum;
			int pos = vertex.v;
			
			if(ans[pos] < vsum) {
				continue;
			}
			
			for(int i = 0 ; i < list[pos].size() ; i++) {
				Edge edge = list[pos].get(i);
				
				if(ans[edge.w] > ans[pos] + edge.cost) {
					ans[edge.w] = ans[pos] + edge.cost;
					
					pq.add(new Vertex(edge.w,ans[edge.w]));
				}
				
				
			}
		}
		
		
		for(int i = 1 ; i <= v;i++) {
			if(ans[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			}
			else {
				bw.write(ans[i]+"\n");
			}
		}
		
		bw.flush();
		
	}
	
}

package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge{
	int v;
	int adjv;
	int cost;
	
	public Edge(int v,int adjv,int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}
}

class Vertex implements Comparable<Vertex>{
	
	int v;
	int sum;
	
	public Vertex(int v,int sum) {
		this.v = v;
		this.sum = sum;
	}
	
	
	public int compareTo(Vertex o) {
		if(this.sum > o.sum) {
			return 1;
		}
		else if(this.sum == o.sum) {
			return 0;
		}
		else {
			return -1;
		}
	}
}


public class B1916 {

	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int v = Integer.parseInt(br.readLine());
		
		int e = Integer.parseInt(br.readLine());
		
		
		ArrayList<Edge> list[] = new ArrayList[v + 1];
		
		for(int i = 1 ; i <= v;i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		
		
		String str[];
		
		for(int i = 0 ; i < e ; i++) {
			str = br.readLine().split(" ");
			list[Integer.parseInt(str[0])].add(new Edge(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
		}
		
		str = br.readLine().split(" ");
		
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);

		int ans[] = new int[v+1];
		
		for(int i = 1 ; i <=v ; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		ans[start] = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		pq.add(new Vertex(start,0));
		
		while(!pq.isEmpty()) {
			Vertex vertex = pq.remove();
			int pos = vertex.v;
			
			if(ans[pos] < vertex.sum) {
				continue;
			}
			
			
			for(int i = 0 ; i < list[pos].size(); i++) {

				Edge edge = list[pos].get(i);
				int adjv = edge.adjv;
				
				if(ans[adjv] > ans[pos] + edge.cost) {
					ans[adjv] = ans[pos] + edge.cost;
					pq.add(new Vertex(adjv, ans[adjv]));
				}
				
			}
		}
		
		
		bw.write(ans[end]+"");
		bw.flush();
		
	}
	
}

package D0908;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class «ÿ≈∑ {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < tc; test++) {
		
			String str[] = br.readLine().split(" ");
		
			int n = Integer.parseInt(str[0]);
			int d = Integer.parseInt(str[1]);
			int start = Integer.parseInt(str[2]);
			
			ArrayList<Edge> list[] = new ArrayList[n+1];
			
			int cost[] = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				cost[i] = Integer.MAX_VALUE;
				list[i] = new ArrayList<Edge>();
			}
			
			for(int i = 0 ; i < d; i++) {
				str = br.readLine().split(" ");
				
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int s = Integer.parseInt(str[2]);
				
				list[b].add(new Edge(b, a, s));
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.add(start);
			cost[start] = 0;
			
			while(!q.isEmpty()) {
				int v = q.remove();
				
				for(int i = 0 ; i < list[v].size();i++) {
					Edge e = list[v].get(i);
					
					if(cost[e.adjv] > cost[e.v] + e.cost) {
						cost[e.adjv] = cost[e.v] + e.cost;
						q.add(e.adjv);
					}
					
				}	
			}
			
			int count = 0;
			int max = Integer.MIN_VALUE;
			
			for(int i = 1 ; i < cost.length;i++) {
				if(cost[i] != Integer.MAX_VALUE) {
					count++;
					if(cost[i] > max) {
						max = cost[i];
					}
				}
			}
			bw.write(count + " " + max +"\n");
		}
		bw.flush();
	}
}

package D0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge>{
	int v;
	int adjv;
	int cost;
	
	public Edge(int v,int adjv,int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}
	
	public int compareTo(Edge o) {
		if(this.cost > o.cost) {
			return 1;
		}
		else if(this.cost == o.cost) {
			return 0;
		}
		else {
			return -1;
		}
	}
}

public class ºñ¿ë {
	
	public static int find(int arr[] , int a) {
		if(arr[a] == a) {
			return a;
		}
		arr[a] = find(arr, arr[a]);
		return arr[a];
		
	}
	
	public static void union(int arr[],int a, int b) {
		int x = find(arr, a);
		int y = find(arr,b);
		
		arr[x] = y;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int v = Integer.parseInt(str[0]);
		
		int data[] = new int[v+1];
		
		for(int i = 1;  i<= v ; i++) {
			data[i] = i;
		}
		
		ArrayList<Edge> edge = new ArrayList<Edge>();
		
		int m = Integer.parseInt(str[1]);
		
		for(int i = 0 ; i < m; i++) {
			str = br.readLine().split(" ");
			
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			
			edge.add(new Edge(x,y,w));
			
			if(find(data,x) != find(data,y)) union(data, x, y);
		}
		
		Collections.sort(edge);
		
		for(int i = 1 ; i <= v;i++) {
			for(int j = 1; j <=v;j++) {
				if(i == j) continue;
				
				while(find(data, i) != find(data, j)) {
					for(int k = 0 ; k < edge.size(); k++) {
						Edge e = edge.get(k);
						
						
					}
				}
				
				
				
				
				
				
				
				
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

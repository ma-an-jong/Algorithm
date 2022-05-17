package Algorithm.Fail;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class 중량제한 {
	
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
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		int data[] = new int[n+1];
		boolean visited[]  = new boolean[n+1];
		
		
		for(int i = 1; i <= n ; i++) {
			data[i] = i;
		}
		
		ArrayList<Edge> edge[] = new ArrayList[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		int m = Integer.parseInt(str[1]);

		
		for(int i = 0 ; i < m ; i++) {
			
			str = br.readLine().split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			
			edge[a].add(new Edge(b,c));
			edge[b].add(new Edge(a,c));	
			
			if(find(data, a) != find(data, b)) {
				union(data, a, b);
			}
			
			
			
		}
		
		str = br.readLine().split(" ");
		
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		
		Queue<Edge> q = new LinkedList<Edge>();
		
			
		while(!q.isEmpty()){
			
			Edge e = q.remove();
			
			if(e.adjv != y && visited[e.adjv]) {
				visited[e.adjv] = true;
				
				
				
				for(int i = 0 ; i < edge[e.adjv].size(); i++) {
					Edge tmp  = edge[e.adjv].get(i);
					q.add(tmp);
				}
			}
			
			
		}
		
		
			
			
			
			
			
	
		
		
		
		
		
		
		
		
		
	
	}
}

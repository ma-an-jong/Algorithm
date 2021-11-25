package D0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Vertex{
	int v;
	int adjv;
	
	public Vertex(int v,int adjv) {
		this.v = v;
		this.adjv = adjv;
	}
	
}


public class 연결요소의개수 {
	
	public static void dfs(ArrayList<Vertex>[] list,boolean visited[],int n) {
		
		visited[n] = true;
		
		for(int i = 0 ; i < list[n].size(); i++) {
			if( !visited[list[n].get(i).adjv]) {
				dfs(list, visited,list[n].get(i).adjv);
			}
		}
		
		
		
	}

	
	public static void main(String args[]) throws Exception{
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			String str[] = br.readLine().split(" ");
			
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			ArrayList<Vertex> list[] = new ArrayList[1001];
			boolean visited[] = new boolean[1001];
			
			
			for(int i = 1; i <= 1000 ; i++) {
				list[i] = new ArrayList<Vertex>();
				visited[i] = false;
			}
			
			
			for(int i = 0 ; i < m ; i++) {
				str = br.readLine().split(" ");
				
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				list[a].add(new Vertex(a,b));
				list[b].add(new Vertex(b,a));
			}
			
			int count = 0;
			
			for(int i = 1 ; i <= n ;i++) {
				if(!visited[i]) {
					dfs(list, visited,i);
					count++;
				}
			}
			
			
			System.out.println(count);
			
			
	}
}

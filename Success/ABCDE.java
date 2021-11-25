package D0903;

import java.io.*;
import java.util.ArrayList;


public class ABCDE {
	
	static boolean flag = false;
	
	public static void dfs(ArrayList<Integer> list[],boolean visited[],int count,int index) {
		
		if(count == 5) {
			
			flag = true;
			return;
		}
		
		
		visited[index] = true;
		
			for(int j = 0 ; j < list[index].size();j++) {
				int vertex = list[index].get(j);
				
				if(!visited[vertex]) {
					
					dfs(list, visited,count + 1,vertex);
				}
				
			}
			
		visited[index] = false;
			
		}
		
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		
		ArrayList<Integer> list[] = new ArrayList[v];
		
		for(int i = 0 ; i < v;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		
		
		for(int i = 0 ; i < e ; i++) {
			str = br.readLine().split(" ");
			
			int vertex = Integer.parseInt(str[0]);
			int adjvertex = Integer.parseInt(str[1]);
			
			list[vertex].add(adjvertex);
			list[adjvertex].add(vertex);
		}
		
		for(int i = 0 ; i < v;i++) {
			
			boolean visited[] = new boolean[v];
			
			dfs(list, visited,1,i);
			if(flag) break;
		}
		
		if(flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	
	}
}

package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class DFS {
	
	public static void DFS(ArrayList<Integer> []arr,int start,boolean visited[]) {
		visited[start] = true;
		System.out.print(start);
		
		for(int i = 0 ; i < arr[start].size();i++) {
			int w = arr[start].get(i);
			
			if(!visited[w]) {
				DFS(arr,w,visited);
			}
		}
		
		
			
		}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m ; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i = 0; i < arr.length;i++) {
			Collections.sort(arr[i]);
		}
		
		
		
		for(int i = 1; i < arr.length;i++) {
			boolean visited[] = new boolean[arr.length];
			
			
			for(int j = 0 ; j < visited.length;j++) {
				visited[i] = false;
			}
			DFS(arr, i,visited);
			System.out.println();
		}
		
	}
}

package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B5567 {
	public static int[] BFS(ArrayList<Integer>[] arr,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];
		
		for(int i = 0;i < visited.length; i++) {
			visited[i] = false;
		}
		
		q.add(start);
		visited[start] = true;
		int cost[] = new int[arr.length];
		cost[start] = 0;
		while(!q.isEmpty()) {
			int t = q.remove();
			
			for(int i = 0 ; i < arr[t].size(); i++) {
				int a = arr[t].get(i);
				
				if(!visited[a]) {
					q.add(a);
					visited[a] = true;
					cost[a] = cost[t] + 1;
				}
			}
		}
		return cost;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str[]; 
		
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
		
		int cost[] = BFS(arr, 1);
		int cnt = 0;
		
		for(int i = 1; i <= n;i++) {
			if(cost[i] <=2 && cost[i] != 0) {
				cnt++;
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
	}
}

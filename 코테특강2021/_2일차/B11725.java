package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B11725 {
	public static int[] BFS(ArrayList[] arr,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];
		
		for(int i = 0;i < visited.length; i++) {
			visited[i] = false;
		}
		int cost[] = new int[arr.length];
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int t = q.remove();
			
			for(int i = 0 ; i < arr[t].size(); i++) {
				int a = (int)arr[t].get(i);
				
				if(!visited[a]) {
					q.add(a);
					visited[a] = true;
					cost[a] = t;
				}
			}
		}
		return cost;
	}
	public static boolean isconnected(ArrayList<Integer>[] arr,int a,int b) {
		for(int i = 0;i<arr[a].size();i++) {
			if(arr[a].get(i) == b) return true;
		}
		return false;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[];

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr[b].add(a);
			arr[a].add(b);
		}

		for (int i = 0; i < arr.length; i++) {
			Collections.sort(arr[i]);
		}
		
		int cost[] = BFS(arr, 1);
		
		for(int i =2 ;i <= n;i++) {
			bw.write(cost[i]+"\n");
					
		}
		
		bw.flush();
	}
}
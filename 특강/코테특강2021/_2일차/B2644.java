package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B2644 {
	public static int BFS(ArrayList<Integer>[] arr, int start,int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		q.add(start);
		visited[start] = true;
		int cost[] = new int[arr.length];
		int cnt = 0;
		while (!q.isEmpty()) {
			int t = q.remove();
			for (int i = 0; i < arr[t].size(); i++) {
				int a = arr[t].get(i);
				
				if (!visited[a]) {
					q.add(a);
					cost[a] = cost[t] +1;
					visited[a] = true;
				}
				
				if(a == target) {
					return cost[a];
				}
				
			}
		}
		return -1;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		int to = Integer.parseInt(str[0]);
		int from = Integer.parseInt(str[1]);

		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr[b].add(a);
			arr[a].add(b);
		}

		for (int i = 0; i < arr.length; i++) {
			Collections.sort(arr[i]);
		}
		
		int result = BFS(arr,to,from);
		
		bw.write(result+"");
		bw.flush();
		
	}
}

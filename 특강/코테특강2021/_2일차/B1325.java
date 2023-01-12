package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B1325 {
	public static int BFS(ArrayList<Integer>[] arr,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];
		int cnt = 0;
		
		for(int i = 0;i < visited.length; i++) {
			visited[i] = false;
		}
		
		q.add(start);
		visited[start] = true;
		cnt++;
		while(!q.isEmpty()) {
			int t = q.remove();
			
			for(int i = 0 ; i < arr[t].size(); i++) {
				int a = arr[t].get(i);
				
				if(!visited[a]) {
					q.add(a);
					visited[a] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		boolean[] flag = new boolean[n+1];
		
		for(int i = 0 ; i < n+1;i++) {
			flag[i] = false;
		}
		
		for (int i = 1; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			arr[b].add(a);
			flag[a] = true;
		
		}
		
		int result[] = new int[n+1];
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i< n+1;i++) {
			if(!flag[i]) {
				result[i] = BFS(arr, i);
			}
			if(result[i]> max) {
				max = result[i];
			}
		}
		
		
		for(int i = 1 ; i < result.length;i++) {
			if(result[i] == max) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}

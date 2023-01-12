package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B1697 {
	public static int BFS(ArrayList<Integer>[] arr,int start,int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];
		
		for(int i = 0;i < visited.length; i++) {
			visited[i] = false;
		}
		int cost[] = new int[arr.length];
		
		q.add(start);
		visited[start] = true;
		cost[start] = 0;
			try {
				arr[start].add(start -1);
				arr[start].add(start +1);
				arr[start].add(start*2);
			}
			catch (Exception e) {
			}
		while(!q.isEmpty()) {
			int t = q.remove();
			
			for(int i = 0 ; i < arr[t].size(); i++) {
				int a = arr[t].get(i);
				try {
				if(!visited[a]) {
					q.add(a);
					
					arr[a].add(a + 1);
					arr[a].add(a - 1);
					arr[a].add(a*2);
					
					visited[a] = true;
					cost[a] = cost[t] + 1;
				}
				if(a == target) {
					return cost[target];
				}
				}
				catch (Exception e) {

				}
			}
		}
				
		return cost[target];
	}

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		
		int me = Integer.parseInt(str[0]);
		int target = Integer.parseInt(str[1]);
		
		ArrayList<Integer>[] arr = new ArrayList[100001];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		int result;
		
		result = BFS(arr,me,target);
		
		
		bw.write(result+"");
		bw.flush();
	}
}

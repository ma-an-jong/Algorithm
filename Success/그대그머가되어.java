package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 그대그머가되어 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		int m = Integer.parseInt(str[1]);
		
		ArrayList<Integer> list[] = new ArrayList[n+1];
		
		for(int i = 1 ; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < m;i++) {
			str = br.readLine().split(" ");
			
			int v = Integer.parseInt(str[0]);
			int adjv = Integer.parseInt(str[1]);
			
			list[v].add(adjv);
			list[adjv].add(v);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int count[] = new int[n+1];
		
		for(int i = 1; i <= n ; i++) {
			count[i] = Integer.MAX_VALUE;
		}
		
		count[start] = 0;
		pq.add(start);
		
		while(!pq.isEmpty()) {
			int vertex = pq.remove();
			
			//확정 코드 없음
			
			for(int i = 0 ; i < list[vertex].size() ; i++) {
				int adjv = list[vertex].get(i);
				
				if(count[adjv] > count[vertex] + 1) {
					count[adjv] = count[vertex] + 1;
					pq.add(adjv);
				}
			}
			
		}
		if(count[end] != Integer.MAX_VALUE) System.out.println(count[end]);
		else System.out.println(-1);
	}
}

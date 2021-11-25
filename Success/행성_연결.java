package D1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	int v;
	int adjv;
	int cost;
	
	public Edge(int v,int adjv,String cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = Integer.parseInt(cost);
	}
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
	
}

public class 행성_연결 {
	
	public static int find(int[] arr,int index) {
		
		if(arr[index] == index) {
			return index;
		}
		
		else {
			arr[index] = find(arr,arr[index]);
			return arr[index];
		}
		
	}
	
	public static boolean union(int[] arr,int a,int b) {
		if(find(arr,a) == find(arr,b)) {
			return false;
		}
		else {
			arr[find(arr,a)] = find(arr,b);
			return true;
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		String str[];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = i;
			str = br.readLine().split(" ");
			for(int j = i + 1 ; j < n;j++) {
				pq.add(new Edge(i,j, str[j]));
				pq.add(new Edge(j,i, str[j]));
			}
		}
		
		long sum = 0;
		int count = 0;
		
		while(count < n-1) {
			Edge edge = pq.remove();
			
			if(find(arr,edge.adjv) != find(arr,edge.v)) {
				sum += edge.cost;
				union(arr, edge.adjv, edge.v);
				count++;
			}

		}
		
		System.out.print(sum);
		
	}

}

package D1101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	
	int v; 
	int adjv;
	int cost;
	
	public Edge(int v,int adjv,int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
		
	}
	
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}

public class ºÒ¿ìÀÌ¿ôµ½±â {
	
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
	
	public static void  main(String args[]) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
	int n = Integer.parseInt(br.readLine());
	int arr[] = new int[n];
		
	for(int i = 0 ; i < n ; i++) {
		arr[i] = i;
	}
	
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	String str;
	int all = 0;
	for(int i = 0 ; i < n ; i++) {
		
		str = br.readLine();
		
		for(int j = 0 ; j < n ; j++) {
			char cost = str.charAt(j);
			int b;
			if('a' <= cost && cost <= 'z') {
				b = cost - 'a' + 1;
			}
			else if(cost == '0') {
				continue;
			}
			else {
				b = cost - 'A' + 27;
			}
			pq.add(new Edge(i, j,b));
			all+= b;
		}

	}
	int count = 0;
	int sum = 0;
	

	while(count < n -1) {
		
		try{
			Edge edge = pq.remove();
			
			if(find(arr,edge.v) != find(arr,edge.adjv)) {
				union(arr, edge.v, edge.adjv);
				sum+=edge.cost;
				count++;
			}
		}
		catch (NoSuchElementException e) {
			sum = 0;
			break;
		}
		
		

	}
	
	
	if(sum == 0) {
		boolean flag = false;
		for(int i = 0 ; i < arr.length;i++) {
			if(arr[i] == i) {
				if(flag) {
					System.out.println(-1);
					return;
				}
				else {
					flag = true;
				}
			}
		}
	}
	
	System.out.println(all - sum);
	
	
	}

	
}

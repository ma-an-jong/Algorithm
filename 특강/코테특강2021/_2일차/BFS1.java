package D0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS1 {
	public static void BFS(ArrayList<Integer>[] arr,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];
		
		for(int i = 0;i < visited.length; i++) {
			visited[i] = false;
		}
		
		q.add(start);
		visited[start] = true;
		System.out.print(start);
		
		while(!q.isEmpty()) {
			int t = q.remove();
			
			for(int i = 0 ; i < arr[t].size(); i++) {
				int a = arr[t].get(i);
				
				if(!visited[a]) {
					q.add(a);
					visited[a] = true;
					System.out.print(a);
				}
			}
		}
	}
	
	public static void main(String args[]) {
	Scanner s = new Scanner(System.in);
	
	int n = s.nextInt();
	int m = s.nextInt();
	
	ArrayList<Integer>[] arr = new ArrayList[m];
	
	for(int i = 0; i < m; i++) {
		arr[i] = new ArrayList<Integer>();
	}
	
	for(int i = 0; i < m ; i++) {
		int a = s.nextInt();
		int b = s.nextInt();
		
		arr[a].add(b);
		arr[b].add(a);
	}
	
	for(int i = 0; i < arr.length;i++) {
		Collections.sort(arr[i]);
	}
	
	
	BFS(arr, 1);
	System.out.println();
	BFS(arr, 2);
	System.out.println();
	BFS(arr, 3);
	System.out.println();
	BFS(arr, 4);
	System.out.println();
	BFS(arr, 5);
	System.out.println();
	BFS(arr, 6);
	System.out.println();
	BFS(arr, 7);
	}
}

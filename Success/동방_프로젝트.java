package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동방_프로젝트 {
	
	public static int find(int arr[] , int a) {
		if(arr[a] == a) {
			return a;
		}
		arr[a] = find(arr, arr[a]);
		return arr[a];
		
	}
	
	public static void union(int arr[],int a, int b) {
		int x = find(arr, a);
		int y = find(arr,b);
		
		arr[x] = y;
	}
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int data[] = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			data[i] = i;
		}
		
		
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m ; i++) {
			String str[] = br.readLine().split(" ");
			
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			for(int j = x ; j < y ; j++) {
				
				if(find(data,j) != find(data,j+1)) 
				{
					union(data, j, j+1);
					n--;
				}
			}
	
		}
		
		System.out.println(n);
		
		
	}
}

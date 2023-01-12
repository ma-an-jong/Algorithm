package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class AdjList {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m ; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arr[b].add(a);
		}
		
		for(int i = 0; i < arr.length;i++) {
			Collections.sort(arr[i]);
		}
		
		
		
	}
}

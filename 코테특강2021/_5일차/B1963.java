package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B1963 {
	public static void main(String args[]) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean visited[] = new boolean[10001];
	
		for (int i = 0; i <= 10000; i++) {
			visited[i] = false;
		}

		visited[1] = true;
		visited[0] = true;

		for (int i = 1; i < Math.sqrt(10000) + 1; i++) {
			if (visited[i] == false) {
				int index = i * i;
				for (int j = index; j < visited.length; j = j + i) {
					visited[j] = true;
				}
			}
		}
		
		ArrayList<Integer> list[] = new ArrayList[10000];
		
		
		for(int i = 1000; i < 10000;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1000; i < 10000;i++) {
			if(!visited[i]) {
adsffds
			
			
			}
		}
		
		
	}
}
package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B9020 {
	public static void main(String args[]) throws Exception {
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
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n;i++) {
			int g = Integer.parseInt(br.readLine());
			for(int j = g/2; j > 1;j--) {
				if(visited[j] == false && visited[g-j] == false) {
					bw.write(j+" "+(g-j) + "\n");
					break;
				}
			}
			
		}
		bw.flush();
		
	}
}

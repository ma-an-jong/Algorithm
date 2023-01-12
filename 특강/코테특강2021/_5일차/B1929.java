package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1929 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		boolean visited[] = new boolean[1000001];
	
		for (int i = 0; i <= 1000000; i++) {
			visited[i] = false;
		}

		visited[1] = true;
		visited[0] = true;

		for (int i = 1; i < Math.sqrt(1000000) + 1; i++) {
			if (visited[i] == false) {
				int index = i * i;
				for (int j = index; j < visited.length; j = j + i) {
					visited[j] = true;
				}
			}
		}


		String str[] = br.readLine().split(" ");
		
		int low = Integer.parseInt(str[0]);
		int high = Integer.parseInt(str[1]);
		
		
		
		for(int i = low; i <= high ;i++) {
			if(visited[i] == false) {
				bw.write(i+"\n");
			}
		}
		
		bw.flush();
	}
}
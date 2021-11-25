package D0928;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 베르트랑_공준 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean visited[] = new boolean[123456*2 + 1];
		
		visited[0] = true;
		visited[1] = true;
		
		for(int i = 2; i < Math.sqrt(visited.length);i++) {
			if(!visited[i]) {
				int pnt = i *i;
				for(int j = pnt ; j < visited.length; j = j + i) {
					if(!visited[j]) visited[j] = true;
				}
			}
		}
		
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			int cnt = 0;
			
			for(int i = n+1 ; i < 2*n+1;i++) {
				if(!visited[i]) cnt++;
			}
			
			bw.write(cnt+"\n");
			
		}
		
		bw.flush();
		
		
	}
}

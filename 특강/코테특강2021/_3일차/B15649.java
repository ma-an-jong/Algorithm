package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B15649 {
	
	public static void perm(int ans[],int data[],int visited[],int depth, int n, int r,BufferedWriter bw) throws Exception {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				bw.write(ans[i]+" ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				ans[depth] = i;
				perm(ans,data,visited,depth + 1, n, r,bw);
				visited[i] = 0;
			}
		}
	}

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		
		int data[] = new int[n + 1];
		
		
		int visited[] = new int[n+1];
		for(int i = 1; i < data.length;i++) {
			data[i] = i;
		}
		
		int ans[] = data;
		
		perm(ans,data, visited, 0, n, m,bw);
		
		
		bw.flush();
	}
}

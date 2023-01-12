package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B7795 {
	public static void main(String args[]) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int k = 0 ; k < tc ; k++) {

			String str[] = br.readLine().split(" ");
			
			
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			int A[] = new int[n];
			
			str = br.readLine().split(" ");
			
			for(int i = 0 ; i <n; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
			
			int B[] = new int[m];
			
			str = br.readLine().split(" ");
			
			for(int i = 0 ; i  < m; i++) {
				B[i] = Integer.parseInt(str[i]);
			}
			
			
			Arrays.sort(A);
			Arrays.sort(B);
			int cnt = 0;
			
			for(int i = 0; i < n ;i++) {
				for(int j = 0; j < m ; j++) {
					if(A[i] > B[j]) {
						cnt++;
					}
					else {
						break;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
	}
}

package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B9372 {
	public static int findset(int data[],int p) {
		if(p == data[p])
			return p;
		data[p] = findset(data, data[p]);
		return data[p];
	}
	
	public static void unionset(int data[],int a,int b) {
		int ap = findset(data, a);
		int bp = findset(data, b);
		data[ap] = bp; 
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int k = 0 ; k < tc;k++) {
			
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int data[] = new int[n + 1];
		
		for(int i = 1; i <= n;i++) {
			data[i] = i;
		}
		
		int cnt = 0;
		
		for(int i = 0 ; i < m ;i++) {
			str = br.readLine().split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
		
			if(findset(data, a) != findset(data, b)) {
				unionset(data, a,b);
				cnt++;
			}
		}
		
		bw.write(cnt+"\n");
		bw.flush();
			
		}
	}
}

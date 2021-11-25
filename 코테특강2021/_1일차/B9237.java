package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B9237 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int cnt = Integer.parseInt(br.readLine());
		String t[] = br.readLine().split(" ");
		int a[] = new int[cnt];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(t[i]);
		}
		Arrays.sort(a);
		for(int i = 0; i < a.length;i++) {
			a[i] = a[i] - i;
			if(max < a[i]) max = a[i];
		}
		max = max + 1 + cnt;
		
		bw.write(max+"");
		
		bw.flush();
		
	}
}

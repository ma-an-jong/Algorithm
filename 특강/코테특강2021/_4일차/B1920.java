package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1920 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int data[] = new int[n];
		
		String str[] = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(data);
		
		int m = Integer.parseInt(br.readLine());
		int flag[] = new int[m];
		
		str = br.readLine().split(" ");
		
		for(int i = 0 ; i <m; i++) {
			int low = 0;
			int high = n-1;
			int mid;
			int target = Integer.parseInt(str[i]);
			while (low <= high) {
				mid = (low + high) / 2;

				if (target > data[mid]) {
					low = mid + 1;
				} else if (target < data[mid]) {
					high = mid - 1;
				} else {
					flag[i] = 1;
					break;
				}
			}
		}
	
		for(int i = 0 ; i < m;i++) {
			bw.write(flag[i] +"\n");
		}
		bw.flush();
	}
}

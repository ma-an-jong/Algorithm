package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B2003 {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		int m = Integer.parseInt(str[1]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		str = br.readLine().split(" ");
		
		list.add(0);
		
		for(int i = 0 ; i < n ;i++) {
			list.add(Integer.parseInt(str[i]));
		}
		
		list.add(0);
		
		
		int left = 1;
		int right = 1;
		
		int cnt = 0;
		int sum = 0;
		
		while(right < n+2) {
			if(sum > m) {
				sum -= list.get(left);
				left++;
			}
			
			else if(sum <= m) {
				
				if(sum == m) {
					cnt++;
				}
				
				sum += list.get(right);
				right++;
			}
			
		}
		
		bw.write(cnt+"");
		bw.flush();
		
	}
}	

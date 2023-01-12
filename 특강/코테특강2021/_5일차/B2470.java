package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B2470 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		
		String str[] = br.readLine().split(" ");
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			list.add(Integer.parseInt(str[i]));
		}
		
		int left = 0;
		int right = list.size() -1;
		
		int sum = 0;
		
		int zero = Integer.MAX_VALUE;
		
		int ans1 = 0;
		int ans2 = 0;
		
		
		while(left != right) {
			
			sum = list.get(left) + list.get(right);
			
			if(Math.abs(sum) < zero) {
				zero = Math.abs(sum);
				ans1 = left;
				ans2 = right;
			}
			
			if(sum >= 0) {
				if(sum == 0) {
					ans1 = left;
					ans2 = right;
					break;
				}
				right--;
			}
			else if(sum < 0) {
				left++;
			}
		}
		
		bw.write(list.get(ans1) + " " + list.get(ans2) );
		bw.flush();
	}
}

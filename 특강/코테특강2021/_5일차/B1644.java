package D0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B1644 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean visited[] = new boolean[4000001];
	
		for (int i = 0; i <= 4000000; i++) {
			visited[i] = false;
		}

		visited[1] = true;
		visited[0] = true;

		for (int i = 1; i < Math.sqrt(4000000) + 1; i++) {
			if (visited[i] == false) {
				int index = i * i;
				for (int j = index; j < visited.length; j = j + i) {
					visited[j] = true;
				}
			}
		}
		
		
		int target = Integer.parseInt(br.readLine());
		
		int sum = 0 ;
		int cnt = 0;
		int left = 0;
		int right = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < visited.length;i++) {
			if(!visited[i]) {
				list.add(i);
			}
		}
		
		
		while(right < list.size()){
			
			if(sum <= target) {
				if(sum == target) cnt++;
				sum += list.get(right);
				right++;
			}
			
			else if(sum > target) {
				sum -= list.get(left);
				left++;
			}
			
		}
		
		bw.write(cnt+"");
		bw.flush();
		
	}
}

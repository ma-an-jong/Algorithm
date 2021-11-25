package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¿ëµ·_°ü¸® {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int data[] = new int[N];
		
		int M = Integer.parseInt(str[1]);
		
		int m = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			data[i] = Integer.parseInt(br.readLine());
			if(m < data[i]) m = data[i];
		}
		
		
		int front = m;
		int back = 10000 * N;
		
		while(true) {
			
			if(front > back) break;
			
			int bank = 0;
			int count = 0;
			
			int mid = (front + back)/2;
			
			for(int i = 0 ; i < N ; i++) {
				
				if(mid < bank + data[i]) {
					bank = 0;
					count++;
				}
				
				bank += data[i];	
			}
			if(bank != 0) count++;
            if(count <= M) back = mid - 1;
            else front = mid + 1;
		}
		
		System.out.println(front);
	}
}

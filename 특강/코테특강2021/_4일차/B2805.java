package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2805 {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int tree[] = new int[n];
		long size = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		
		int low = 0;
		int high = 1000000000;
		int ans = 0;
		for(int i = 0 ; i < n;i++) {
			tree[i] = Integer.parseInt(str[i]);
			if(tree[i] > high) high = tree[i];
			if(tree[i] < low) low = tree[i];
		}
		
		int mid;
		
		while(low <= high) {
			mid = (low + high)/2;
			long count = 0;
			for(int i = 0 ; i < n;i++) {
				if(mid < tree[i]) {
					count += tree[i] - mid;
				}
			}
			
			if(count > size) {
				low = mid + 1 ;
				ans = mid;
			}
			else if(count < size) {
				high = mid - 1;
			}
			else {
				ans = mid;
				break;
			}
		}
		
		
		bw.write(ans+"");
		bw.flush();
		
	}

}




package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class º¸¹° {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer A[] = new Integer[N];
		Integer B[] = new Integer[N];
		String str[] = br.readLine().split(" ");
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		str=  br.readLine().split(" ");
		for(int i = 0 ; i < N; i++) {
			B[i] = Integer.parseInt(str[i]);
		}
		
		
		Arrays.sort(A);
		Arrays.sort(B, new Comparator<Integer>() {
		
			public int compare(Integer o1,Integer o2) {
				return o2 - o1;
			}
		
		});
		
		int ans = 0;
		for(int i = 0 ; i < N; i++) {
			ans += A[i]*B[i];
		}
		
		System.out.println(ans);
		
		
	}

}

package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 배열_합치기 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int a[] = new int[N];
		
		int M = Integer.parseInt(str[1]);
		int b[] = new int[M];

		
		str = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		str = br.readLine().split(" ");
		for(int i = 0 ; i < M ; i++) {
			b[i] = Integer.parseInt(str[i]);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int bp = 0;
		int ap = 0;
		
		while(true) {
			if(ap == N) {
				while(bp != M) {
					list.add(b[bp]);
					bp++;
				}
				break;
			}
			
			if(bp == M) {
				while(ap != N) {
					list.add(a[ap]);
					ap++;
				}
				break;
			}
			
			if(a[ap] > b[bp]) {
				list.add(b[bp]);
				bp++;
			}
			else {
				list.add(a[ap]);
				ap++;
			}
			
		}
		
		for(int i = 0; i < N + M; i++) {
			bw.write(list.get(i) + " ");
		}
		
		bw.flush();

	}
}

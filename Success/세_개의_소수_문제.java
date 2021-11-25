package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 세_개의_소수_문제 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		boolean visited[] = new boolean[1001];
		visited[0] = true;
		visited[1] = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 2; i < Math.sqrt(1001); i++) {
			if(!visited[i]) {
				int pnt = i*i;
				for(int j = pnt; j < 1001;j = j + i) {
					if(!visited[j]) visited[j] = true;
					
				}
			}
		}
		
		for(int i = 2; i < 1001;i++) {
			if(!visited[i]) list.add(i);
		}

		for(int i = 0 ; i < T ; i++) {	
			int k = Integer.parseInt(br.readLine());
			
			int arr[] = new int[3];
			
			for(int a = 0; a < list.size();a++) {
				for(int b = 0 ; b < list.size();b++) {
					int v1 = list.get(a);
					int v2 = list.get(b);
					int x = k-v1-v2;
					try {
						if(!visited[x]) {
							arr[0] = v1;
							arr[1] = v2;
							arr[2] = x;
						}
					}
					catch (Exception e) {

					}
				}
			}
			Arrays.sort(arr);
			bw.write(arr[0] + " " + arr[1] + " " + arr[2]+"\n");
			
		}
		bw.flush();
	}
}

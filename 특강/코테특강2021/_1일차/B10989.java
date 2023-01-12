package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10989 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		
		int arr[] = new int[size];
		
		for(int i = 0; i < size;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count[] = new int[10001];
		
		for(int i = 0; i < arr.length;i++) {
			count[arr[i]]++;
		}
		
		for(int i = 0 ; i <count.length;i++) {
			while(count[i] != 0) {
				bw.write(i+"\n");
				count[i]--;
			}
		}
		
		bw.flush();
		
	}

}

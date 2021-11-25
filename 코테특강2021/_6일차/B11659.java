package D0830;
//구간합 구하기4
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11659 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		
		int m = Integer.parseInt(str[1]);
		
		int data[] = new int[n];
		int sum[] = new int[n+1];
		
		str = br.readLine().split(" ");
	
		
		for(int i = 1 ; i <= n;i++) {
			data[i-1] =  Integer.parseInt(str[i-1]);
			
			sum[i] = sum[i-1]+data[i-1];
		}
		
		
		for(int i = 0 ; i < m ;i++) {
			str = br.readLine().split(" ");
			
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			
			bw.write(sum[end] - sum[start - 1] +"\n");
			
		}
		
		bw.flush();
		
	}
}

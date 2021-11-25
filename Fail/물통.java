package D0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class π∞≈Î {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");		
		
		boolean data[] = new boolean[201];
			
		int MAXA = Integer.parseInt(str[0]);
		int MAXB = Integer.parseInt(str[1]);
		int MAXC = Integer.parseInt(str[2]);
		
		int MAX[] = {MAXC,MAXB,MAXA};
		
		int bottle[] = {MAXC,0,0};
		
		
			
		for(int i = 0 ; i < data.length;i++) {	
			if(data[i])
			System.out.print(i + " ");
		}
		
	}
}

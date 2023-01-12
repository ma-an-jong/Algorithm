package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2755 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		
		double cnt = 0.0;
		int sum = 0;
		
		for(int i = 0; i<size;i++) {
			String str[] = br.readLine().split(" ");
			
			int score = Integer.parseInt(str[1]);
			
			if(str[2].equals("A+")) {
				cnt = cnt + 4.3*score;
				sum = sum + score;
			}
			else if(str[2].equals("A0")) {
				cnt = cnt + 4.0*score;
				sum = sum + score;
			}
						
			else if(str[2].equals("A-")) {
				cnt = cnt + 3.7*score;
				sum = sum + score;
			}
						
			else if(str[2].equals("B+")) {
				cnt = cnt + 3.3*score;
				sum = sum + score;
			}
			else if(str[2].equals("B0")) {
				cnt = cnt + 3.0*score;
				sum = sum + score;
			}
			else if(str[2].equals("B-")) {
				cnt = cnt + 2.7*score;
				sum = sum + score;
			}
			else if(str[2].equals("C+")) {
				cnt = cnt + 2.3*score;
				sum = sum + score;
			}
			else if(str[2].equals("C0")) {
				cnt = cnt + 2.0*score;
				sum = sum + score;
			}
			else if(str[2].equals("C-")) {
				cnt = cnt + 1.7*score;
				sum = sum + score;
			}
			else if(str[2].equals("D+")) {
				cnt = cnt + 1.3*score;
				sum = sum + score;
			}
			else if(str[2].equals("D0")) {
				cnt = cnt + 1.0*score;
				sum = sum + score;
			}
			else if(str[2].equals("D-")) {
				cnt = cnt + 0.7*score;
				sum = sum + score;
			}
			else if(str[2].equals("F")) {
				sum = sum + score;
			}
		}
		
		double ans = Math.round(cnt/sum*100)/100.0;
		
		System.out.println(String.format("%.2f", ans));
	}
}

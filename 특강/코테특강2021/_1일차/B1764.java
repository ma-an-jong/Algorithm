package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1764 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		String[] s1 = s.split(" ");
		
		int count1 = Integer.parseInt(s1[0]);
		int count2 = Integer.parseInt(s1[1]);
		
		String dj[] = new String[count1 + count2];
		for(int i = 0 ; i < count1 + count2; i++) {
			dj[i] = br.readLine();
		}
		
		Arrays.sort(dj);
		
		int count = 0;
		String result = "";
		for(int i = 0; i < dj.length-1;i++) {
	
			if(dj[i].equals(dj[i+1])) {
				count++;
				result = result + dj[i] + "\n";
			
			}
		}
		bw.write(count + "\n");
		bw.write(result);
		bw.flush();
	}
}

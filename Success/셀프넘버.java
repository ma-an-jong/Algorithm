package D1102;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ¼¿ÇÁ³Ñ¹ö {
	public static void main(String[] args) throws Exception {
	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int n = 10000;
		
	boolean table[] = new boolean[n];
	 
	for(int i = 1; i < n;i++) {
			int mod = 1;
			
			int result = i;
			
			for(int j = 0 ; j <= Math.log10(i);j++ ) 
			{
				result += (i/mod)%10;
				mod*=10;
			}
			try {
				table[result] = true;
			}
			catch (Exception e) {
				
			}
	}
	
	for(int i = 1 ; i < n ; i++) {
		if(!table[i]) {
			bw.write(i + "\n");
		}
	}
	bw.flush();

	}

}

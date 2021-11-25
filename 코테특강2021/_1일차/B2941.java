package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2941 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String s = br.readLine();
	
		
		s = s.replace("c=","A");
		s = s.replace("c-","A");
		s = s.replace("dz=","A");
		s = s.replace("d-","A");
		s = s.replace("lj","A");
		s = s.replace("nj","A");
		s = s.replace("s=","A");
		s = s.replace("z=","A");
		
		bw.write(s.length() +"");
		bw.flush();
		
		
		
	}
	
}

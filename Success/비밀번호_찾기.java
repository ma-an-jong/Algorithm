package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 비밀번호_찾기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		for(int i = 0; i < n; i ++) {
			str = br.readLine().split(" ");
			
			map.put(str[0], str[1]);
		}
		String s;
		for(int i = 0 ; i < m ;i ++) {
			s = br.readLine();
			bw.write(map.get(s)+"\n");
		}
		
		bw.flush();
		
	}
}

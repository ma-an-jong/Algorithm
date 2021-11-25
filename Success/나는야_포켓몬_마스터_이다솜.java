package 빼빼로데이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		String name;
		
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		String data[] = new String[n+1];
		
		for(int i = 1 ; i <= n ; i ++) {
			name = br.readLine();
			
			map.put(name,i);
			data[i] = name;
			
		}
		
		String query;
		int intQuery;
		for(int i = 0 ; i < m; i++) 
		{
			
			query = br.readLine();
			
			try 
			{
				intQuery = Integer.parseInt(query);
				bw.write(data[intQuery] +"\n");
				
			}
			catch(Exception e) 
			{
				bw.write(map.get(query) +"\n");
			}
			
		}
		
		bw.flush();
	}
}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 진법_변환 {
	
	static String value = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0 ; i < value.length();i++) 
		{
			map.put(value.charAt(i),i);
		}
		
		
		String str[] = br.readLine().split(" ");
		String N = str[0];
		int B = Integer.parseInt(str[1]);
		int ans = 0;
		for(int i = 0 ; i < N.length();i++) 
		{
			ans *= B;
			ans += map.get(N.charAt(i));
		}
		
		System.out.println(ans);

	}

}

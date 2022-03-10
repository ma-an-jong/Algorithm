package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¿µÈ­°¨µ¶_¼ò {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String target = "666";
		int count = 0;
		
		for(long i = 666;i <= Long.MAX_VALUE ; i++)
		{
			String source = String.valueOf(i);
			
			if(source.contains(target)) {
				count++;
			}
			
			if(count == N)
			{
				System.out.println(i);
				break;
			}
		}
		
	}
}
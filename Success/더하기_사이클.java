package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 더하기_사이클 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int x = N;
		
		int count = 0;
		
		if(x < 10)
		{
			x += x*10;
			count++;
		}
		
		while(true)
		{
			if(count != 0 && x == N )
			{
				System.out.println(count);
				return;
			}
			
			x = (x%10)*10 + (x/10 + x%10)%10;
			count++;
		}
		

	}

}

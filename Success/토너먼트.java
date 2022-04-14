package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 토너먼트 {
	
	 static int jimin;
	 static int hansu;

	 
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		jimin = Integer.parseInt(str[1]);
		hansu = Integer.parseInt(str[2]);
		int round = 1;
		
		while(N > 1)
		{
			
			int count = 0;
			
			for(int i = 1; i <= N; i+=2)
			{
				
				count+=1;
				
				if((i == jimin && i+1 == hansu) || (i == hansu && i+1 == jimin)) 
				{
					System.out.println(round);
					return;
				}
				
				
				
				if(i == jimin || i+1 == jimin )
				{
					jimin = count;
				}
				else if(i == hansu || i+1 == hansu)
				{
					hansu = count;
				}
			}
			
			N = count;
			round++;

		}
		
		System.out.println(-1);
		
		
		
		
	}
}

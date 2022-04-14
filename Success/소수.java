package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¼Ò¼ö {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean data[] = new boolean[N];
		
		data[0] = true;
		data[1] = true;
		
		for(int i = 2 ; i < N ; i++)
		{
			if(!data[i])
			{
				for(int k = i*2; k < N ; k += i)
				{
					data[k] = true;
				}
			}
		}
		
		int sum = 0; 
		int min = Integer.MAX_VALUE;
		for(int i = M ; i <= N ; i++)
			
		{
			if(!data[i])
			{
				min = Math.min(min, i);
				sum += i;
			}
		}
		
		
		if(min != Integer.MAX_VALUE)
		{
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
		
		
		
	}
}

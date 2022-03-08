package Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 가장_긴_증가하는_부분_수열 {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		int A[] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		int LCS[] = new int[N];
		
		for(int i = 0 ; i < N ; i++)
		{
			LCS[i] = 1;
		}
		
		for(int i = 0 ; i < N; i++)
		{
			for(int j = 0; j < i ; j++)
			{
				if(A[i] > A[j] && LCS[i] < LCS[j] + 1)
				{
					LCS[i] = LCS[j] + 1;
				}
			}
			
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++)
		{
			max = Math.max(max, LCS[i]);
		}
		System.out.println(max);
	}
}	



package D1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 계단오르기 {
	
	public static void get(int score[],int memo[],int dp[],int i,int sum,int count) {
		
		if(i >= score.length) {
			return;
		}
		
		if(count == 2) 
		{
			
			try {
				
				if(memo[i+2] < sum + score[i+2]) 
				{
					memo[i+2] = sum + score[i+2];
				}
				else 
				{
					return;
				}
				
				get(score, memo,dp, i+2, sum + score[i+2],1);
			}
			catch (Exception e) {
				
			}
		}
		else 
		{
			try {
				if(count == 1) 
				{
					if(dp[i+1] < sum + score[i+1]) 
					{
						dp[i+1] = sum + score[i+1];
						
					}
					else {
						return;
					}
					
					get(score, memo,dp, i+1, sum + score[i+1],count+1);
				}
				else 
				{
					if(memo[i+1] < sum + score[i+1]) 
					{
						memo[i+1] = sum + score[i+1];
					}
					else {
						return;
					}
					
					get(score, memo,dp, i+1, sum + score[i+1],count+1);
				}
					
				
			}
			catch (Exception e) {

			}
			
			try 
			{
				if(memo[i+2] < sum + score[i+2]) 
				{
					memo[i+2] = sum + score[i+2];
				}
				else
				{
					return;
				}
				
				
				get(score, memo,dp, i+2, sum + score[i+2], 1);
			}
			catch (Exception e) {

			}
			
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int score[] = new int[n+1];
		int memo[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			score[i] = Integer.parseInt(br.readLine());
			memo[i] = 0;
			dp[i] = 0;
		}
		
		get(score, memo,dp,0,0,0);
		
		
		System.out.println(Math.max(dp[n],memo[n]));
		
	
	}

}

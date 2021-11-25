package D1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ¿¬¼ÓÇÕ {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int score[] = new int[n];
		
		String str[] = br.readLine().split(" ");
		
		int max= Integer.MIN_VALUE;
		
		for(int i = 0 ; i < n; i++) {
			score[i] = Integer.parseInt(str[i]);
			max = Math.max(score[i],max);
		}

		int sum = 0;
		
		for(int i = 0 ; i < n; i++) {
			
			sum += score[i];
			
			max = Math.max(max, sum);
			
			if(sum < 0) 
			{
				sum = 0;
			}
			
		}

			System.out.println(max);
	
	}

}

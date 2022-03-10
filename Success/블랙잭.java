package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ∫Ì∑¢¿Ë {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int card[] = new int[N];
		
		str = br.readLine().split(" ");
		
		for(int i = 0; i < N;i++) {
			card[i] = Integer.parseInt(str[i]);
		}
		int max = 0;
		
		for(int i = 0; i < N ; i++) {
			for(int j = i+1; j < N ; j++) {
				for (int k = j+1; k < N ; k++) {
					
					int answer = card[i] + card[j] + card[k];
					
					if(answer <= M && answer > max) 
					{
						max = answer;
					}
					
				}
			}
		}
		System.out.println(max);
		
	}
}

package Trying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class 숫자_카드_2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		int cards[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int M = Integer.parseInt(br.readLine());
		int targets[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(cards);
		
		
		for(int i = 0 ; i < M ; i++)
		{
			
			int front = 0;
			int back = N-1;
			int mid = (front+back)/2;
			
			while(front < back)
			{
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}

}

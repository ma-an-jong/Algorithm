package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 숫자_카드_2 {
	
	public static void foo(int[] arr,int targets[],int i,int front,int back)
	{
		
		int mid = (front+back) / 2;
		
		if(front > back) {
			lower = front;
			return;
		}
		
		if(targets[i] <= arr[mid])
		{
			 foo(arr,targets,i,front,mid-1);
		}
		else
		{
			foo(arr,targets,i,mid+1,back);
		}
		
	}
	
	public static void foo1(int[] arr,int targets[],int i,int front,int back)
	{
		
		int mid = (front+back) / 2;
		
		if(front > back) {
			upper = front;
			return;
		}
		
		if(targets[i] < arr[mid])
		{
			 foo1(arr,targets,i,front,mid-1);
		}
		else
		{
			foo1(arr,targets,i,mid+1,back);
		}
		
	}
	
	
	
	static int lower = Integer.MAX_VALUE;
	static int upper = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		int cards[] = new int[N];
		for(int i = 0 ; i < N ; i++)
		{
			cards[i] = Integer.parseInt(str[i]);
		}
	
		int M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		int targets[] = new int[M];
		for(int i = 0 ; i < M ; i++) {
			targets[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(cards);
		
		for(int i = 0 ; i < M ; i++)
		{
			lower = Integer.MAX_VALUE;
			foo(cards,targets,i,0,N-1);
			upper = Integer.MIN_VALUE;
			foo1(cards,targets,i,0,N-1);
			
			if(lower == Integer.MAX_VALUE && upper == Integer.MIN_VALUE)
			{
				bw.write(String.valueOf(0));
				bw.write(" ");
			}
			else
			{
				bw.write(String.valueOf(upper - lower));
				bw.write(" ");
			}
		}
		
		bw.flush();
		
	}

}

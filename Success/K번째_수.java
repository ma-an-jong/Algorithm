package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class K¹øÂ°_¼ö {

	public static void foo(int N,int k,int front,int back) 
	{
		
		if(back < front) {
			ans = front;
			return;
		}
		
		int mid = (front + back) / 2;
		
		int cnt = 0;
		
		for(int i = 1 ; i <= N ; i++)
		{
			cnt += Math.min(mid / i , N);
		}
		
		if(cnt >= k)
		{
			foo(N,k,front,mid-1);
		}
		else
		{
			foo(N,k,mid+1,back);
			
		}

	}
	
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		
		foo(N,k,0,k);
		
		System.out.println(ans);
		

	}

}

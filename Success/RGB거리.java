package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RGB°Å¸® {
	
	static class House{
		int red;
		int green;
		int blue;
		char choice;
		
		public House(int r,int g,int b)
		{
			red = r;
			green = g;
			blue = b;
		}
	}
	
	static int memo[][];
	static int min = Integer.MAX_VALUE;
	static int n;
	static House data[];
	
	public static void foo(int now,int sum,int start)
	{
		if(now == n)
		{
			min = Math.min(min, sum);
			return;
		}
		
		if(sum >= memo[now][start])
		{	
			return;
		}
		else
		{
			memo[now][start] = sum;
		}

		if(data[now-1].choice == 'r')
		{
			
			data[now].choice = 'g';
			foo(now+1,sum+data[now].green,1);
			data[now].choice = 'b';
			foo(now+1,sum+data[now].blue,2);
			
		}
		else if(data[now-1].choice == 'g')
		{
			data[now].choice = 'r';
			foo(now+1,sum+data[now].red,0);
			data[now].choice = 'b';
			foo(now+1,sum+data[now].blue,2);
		}
		else
		{
			data[now].choice = 'r';
			foo(now+1,sum+data[now].red,0);
			data[now].choice = 'g';
			foo(now+1,sum+data[now].green,1);
		}		
		
		
	}
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		memo = new int[n][3];
		data = new House[n];
		String str[];
		
		for(int i = 0 ; i < n ; i++) 
		{
			str = br.readLine().split(" ");
			data[i] = new House(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			memo[i][0] = Integer.MAX_VALUE;
			memo[i][1] = Integer.MAX_VALUE;
			memo[i][2] = Integer.MAX_VALUE;
		}

		
		data[0].choice = 'r';
		foo(1,data[0].red,0);

		data[0].choice = 'g';
		foo(1,data[0].green,1);

		data[0].choice = 'b';
		foo(1,data[0].blue,2);
		
		System.out.println(min);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

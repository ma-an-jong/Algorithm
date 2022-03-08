package Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Æò¹üÇÑ_¹è³¶ {
	static class Item implements Comparable<Item>{
		int cost;
		int weight;
		
		public Item(int w,int c) {
			cost = c;
			weight = w;
		}
		
		public int compareTo(Item o)
		{
			int a = this.weight - o.weight;
			
			if(a == 0) {
				return this.cost - o.cost;
			}
			else {
				return a;
			}
		}
		
	}
	
	static int foo(int weight,int cost,int now)
	{
		if(weight > k ) return Integer.MIN_VALUE;
		
		if(now > n-1)
		{
			return 0;
		}
		
		if(cost > memo[now][])
		
		return memo[now][];
		
	}
	
	static int n;
	static int k;
	static int memo[][];
	static Item data[];
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		
		data = new Item[n];
		memo = new int[n][n];
		
		for(int i = 0 ; i < n ; i++)
		{
			str = br.readLine().split(" ");
			data[i] = new Item(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			for(int j = 0 ; j < n ; j ++)
			{
				memo[i][j] = Integer.MIN_VALUE;
			}
		}
		
		Arrays.sort(data);
		
		int ans = foo(0,0,0);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0 ; j < n;j++) {
				if(memo[i][j] == Integer.MIN_VALUE) {
					System.out.print("x ");
				}
				else {
					System.out.print(memo[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println(ans);
		
		
		
	}
}

/*
10 999
46 306
60 311
33 724
18 342
57 431
49 288
12 686
89 389
82 889
16 289
*/
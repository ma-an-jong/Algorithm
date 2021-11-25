package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
class Bridge implements Comparable<Bridge>{
	int v;
	int adjv;
	int length;
	
	public Bridge(int a,int b,int c) {
		v = a;
		adjv = b;
		length = c;
	}
	
	@Override
	public int compareTo(Bridge o) {
		return length - o.length;
	}
	
}

public class 다리만들기2 {
	
	/*
	 * 
	 * 다리길이는 항상 2 이상이어야함 
	 * 다리 방향 중간에 바뀌면 안됨
	 * 인접 방향이 같아야함
	 * 
	 */
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	public static int num = 1;
	
	public static int find(int data[],int v)
	{
		if(data[v] == v) {
			return data[v];
		}
		else {
			data[v] = find(data,data[v]);
			return data[v];
		}
	}
	
	
	public static boolean union(int data[],int a,int b)
	{
		int ap = find(data,a);
		int bp = find(data,b);
		
		if(ap != bp)
		{
			data[ap] = bp;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		int table[][] = new int[h][w];
		char input[][] = new char[h][w];
		
		for(int i = 0 ; i < h ; i++) {
			str = br.readLine().split(" ");
			
			for(int j = 0 ; j < w ; j ++) {
				if(str[j].equals("1"))
				{
					input[i][j] = '1';
				}
				else
				{
					input[i][j] = '0';
				}
			}
		}
		
		for(int i = 0 ; i < h; i++)
		{
			for(int j = 0 ; j < w ; j++)
			{
				
				if(input[i][j] == '1' && table[i][j] == 0) 
				{
					table[i][j] = num++;
					Queue<Integer> qx = new LinkedList<Integer>();
					Queue<Integer> qy = new LinkedList<Integer>();
					
					qx.add(j); qy.add(i);
					
					while(!qx.isEmpty())
					{
						int x = qx.remove();
						int y = qy.remove();
						
						for(int k = 0; k < 4; k++)
						{
							try 
							{
								int mx = x + dx[k];
								int my = y + dy[k];
								
								if(input[my][mx] == '1' && table[my][mx] == 0)
								{  
									table[my][mx] = table[i][j];
									qx.add(mx);
									qy.add(my);
								}
								
							}
							catch (Exception e) 
							{
							
							}
						}
					}
				}
				
			}
		}
		
		PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>();
		
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < w ; j++) {
				if(table[i][j] != 0) {
					
					int v = table[i][j];
					
					for(int k = 0; k < 4; k++) 
					{
						
						int x = j + dx[k];
						int y = i + dy[k];
						
						int length = 0;
						
						try 
						{
							while(table[y][x] == 0)
							{
								length++;
								x += dx[k];
								y += dy[k];
							}
							
							if(v != table[y][x] && length >= 2)
							{
								pq.add(new Bridge(v, table[y][x], length));
							}
							
						}
						catch (Exception e)
						{
							
						}
					}
					
				}
			}
		}
		
		int data[] = new int[num];
		
		for(int i = 1 ; i < num;i++) {
			data[i] = i;
		}
		
		int sum = 0;
		
		while(!pq.isEmpty())
		{
			Bridge bridge = pq.remove();
			
			if(find(data,bridge.v) != find(data, bridge.adjv))
			{
				union(data,bridge.v,bridge.adjv);
				sum += bridge.length;
			}

		}
	
		boolean flag = false;
		for(int i = 1; i < num ;i++) 
		{
			if(data[i] == i)
			{
				if(flag)
				{
					System.out.println(-1);
					return;
				}
				else 
				{
					flag = true;
				}
			}
		}
		
		System.out.println(sum);
		
	}
}

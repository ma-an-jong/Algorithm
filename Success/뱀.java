package ª©ª©∑Œµ•¿Ã;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Direction
{
	int time;
	char dir;
	
	public Direction(int t,char d)
	{
		time = t;
		dir = d;
	}
}

class Pos
{
	int x;
	int y;
	
	public Pos(int x,int y) {
		this.x = x;
		this.y = y;
		
	}
}


public class πÏ {
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int go = 0;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char table[][] = new char[n][n];
		 
		int k = Integer.parseInt(br.readLine());
		
		String str[];
		for(int i = 0 ; i < k ; i++) 
		{
			str = br.readLine().split(" ");
			table[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = 'A';
		}
		
		int c = Integer.parseInt(br.readLine());
		
		Queue<Direction> q = new LinkedList<Direction>();
		
		for(int i = 0 ; i < c ; i++)
		{
			str = br.readLine().split(" ");
			q.add(new Direction(Integer.parseInt(str[0]), str[1].charAt(0)));
		}
		
		q.add(new Direction(10000,'X'));
		
		LinkedList<Pos> dummy = new LinkedList<Pos>();
		
		int timer = 0;
		Direction direction;
		
		dummy.add(new Pos(0,0));
		
		while(!q.isEmpty()) 
		{
			direction = q.remove();
			
			for(; timer < direction.time;)
			{
				try 
				{
					timer++;
					Pos tmp = dummy.get(0);
					Pos head = new Pos(tmp.x,tmp.y);
					
						head.x += dx[go];
						head.y += dy[go];
						
						if(table[head.y][head.x] == 'A')
						{
							dummy.add(0,head);
							table[head.y][head.x] = 'X';
						}
						else if(table[head.y][head.x] == 'X')
						{
							System.out.println(timer);
							return;
						}
						else
						{
							dummy.add(0,head);
							table[head.y][head.x] = 'X';
							Pos tail = dummy.removeLast();
							table[tail.y][tail.x] = '\u0000';
						}
						
				}
				catch (Exception e)
				{
					System.out.println(timer);
					return;
				}
				
			}
			
			if(direction.dir == 'L')
			{
				go--;
				go+=4;
				go%=4;
			}
			else if(direction.dir == 'D')
			{
				go++;
				go%=4;
			}
			
		}
		
	}
}

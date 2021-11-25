package D0909;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class Position implements Comparable<Position>{
	int x;
	int y;
	int cost;
	
	public Position(int x,int y,int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	public int compareTo(Position o) {
		if(this.cost > o.cost) return 1;
		else if(this.cost == o.cost) return 0;
		else return -1;
	}
}


public class ¾Ë°í½ºÆÌ {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int w = Integer.parseInt(str[0]);
		int h = Integer.parseInt(str[1]);

		int table[][] = new int[h][w];
		int wall[][] = new int[h][w];
		
		for(int i = 0 ; i < h ; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < s.length();j++) {
				if(s.charAt(j) == '1') table[i][j] = 1;
				wall[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		
		Queue<Position> q = new LinkedList<Position>();
		
		q.add(new Position(0, 0, 0));
		
		
		while (!q.isEmpty()) {
			Position pos = q.remove();
			
			if(wall[pos.y][pos.x] < pos.cost) continue;
			
			for(int i = 0 ; i< 4; i++) {
				int mx = pos.x + dx[i];
				int my = pos.y + dy[i];
			
				
				try {
					
						
					if(table[my][mx] == 1) {
						if(wall[my][mx] > pos.cost+1) {
							q.add(new Position(mx, my, pos.cost + 1));
							wall[my][mx] = pos.cost+1;
						}
					}
					else {
						if(wall[my][mx] > pos.cost) {
							q.add(new Position(mx,my,pos.cost));
							wall[my][mx] = pos.cost;
						}
					}
				}
				catch (Exception e) {

				}
					
				}
			}
		
		
		System.out.println(wall[h-1][w-1]);
			
			
		
	}
}
package Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Room implements Comparable<Room>{
	
	int x;
	int y;
	int count;
	
	public Room(int x,int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
	public int compareTo(Room o) {
		return this.count - o.count;
	}

}


public class 미로만들기 {

	public static void main(String[] args) throws Exception {
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		char table[][] = new char[n][n];
		boolean visited[][] = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for(int j = 0 ; j < n; j++) {
				table[i][j] = line.charAt(j);
			}
		}
		
		PriorityQueue<Room> pq = new PriorityQueue<Room>();
		
		pq.add(new Room(0,0,0));
		
		while(!pq.isEmpty()) {
			
			Room room = pq.remove();
			
			if(room.x == n -1 && room.y == n-1) {
				System.out.println(room.count);
				return;
			}
			
			for(int i = 0; i < 4;i++) {
				int nx = room.x + dx[i];
				int ny = room.y + dy[i];
			
			try {
				if(!visited[ny][nx]) {
					if(table[ny][nx] != '0') {
						pq.add(new Room(nx,ny,room.count));
					}
					else {
						pq.add(new Room(nx,ny,room.count+1));
					}
					visited[ny][nx] = true;
				}
			}
			catch(Exception e) {
				
			}

			}
			
			
		}


	}

}

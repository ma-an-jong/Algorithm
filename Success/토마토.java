package D0910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int day;
	
	public Pos(int x,int y,int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
	
	public int compareTo(Pos o) {
		if(this.day > o.day) return 1;
		else if(this.day == o.day) return 0;
		else return -1;
	}
}
public class ≈‰∏∂≈‰ {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		int w = Integer.parseInt(str[0]);
		int h = Integer.parseInt(str[1]);

		int table[][] = new int[h][w];
		int count[][] = new int[h][w];
		boolean visited[][] = new boolean[h][w];

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		for (int i = 0; i < h; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				table[i][j] = Integer.parseInt(str[j]);
				if(table[i][j] != -1) count[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
		
		int max = Integer.MIN_VALUE;

		for(int i = 0 ; i < h;i++) {
			for(int j = 0 ; j < w;j++) {
				if(table[i][j] == 1) {
					pq.add(new Pos(j, i, 0));
					count[i][j] = 0;
				}
			}
		}
		
		while (!pq.isEmpty()) {
			
			Pos pos = pq.remove();
			
			if(max < pos.day) {
				max = pos.day;
			}
			
			for(int k = 0; k < 4;k++) {
				int mx = pos.x + dx[k];
				int my = pos.y + dy[k];
				
				try {
					if(table[my][mx] == 0 && !visited[my][mx]) {
						visited[my][mx] = true;
						pq.add(new Pos(mx,my,pos.day + 1));
					}
				}
				
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		boolean flag = false;
		for(int i = 0 ; i < h;i++) {
			for(int j = 0 ; j < w;j++) {
				if(!visited[i][j] && table[i][j] == 0) {
					flag = true;
				}
			}
		}
				if(flag) System.out.println(-1);
				else System.out.println(max);
		

	}
}

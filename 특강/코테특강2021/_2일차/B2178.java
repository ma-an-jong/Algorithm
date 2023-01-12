package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Pointer{
	int x;
	int y;
	int count;
	
	public Pointer(int x, int y , int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
}
public class B2178 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str[] = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);

		int matrix[][] = new int[w][h];

		for (int i = 0; i < h; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				matrix[j][i] = tmp.charAt(j) - 48;
			}
		}
		
		Queue<Pointer> q = new LinkedList<Pointer>();
		
		matrix[0][0] = 0;
		q.add(new Pointer(0, 0, 1));
		
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			Pointer point = q.remove();
			
			if(point.x == w -1 && point.y == h -1) {
				if(min > point.count) {
					min = point.count;
				}
				continue;
			}
		
			for(int i = 0 ; i < 4 ; i++) {
				int px = point.x + dx[i];
				int py = point.y + dy[i];
				
				try {
					if(matrix[px][py] == 1) {
						q.add(new Pointer(px, py, point.count+1));
						matrix[px][py] = 0;
					}
				}
				catch (Exception e) {

				}
			}
		}
		
		bw.write(min+"");
		bw.flush();

	}
}

package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 좌표_정렬하기2 {
	static class Position implements Comparable<Position>{
		
		int x;
		int y;
		
		public Position(int x , int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Position o) {
			if(this.y != o.y)
			{
				return this.y-o.y;
			}
			else {
				return this.x-o.x;
			}
		}
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Position pos[] = new Position[N];
		String str[];
		
		for(int i = 0; i < N ; i++) {
			str = br.readLine().split(" ");
			pos[i] = new Position(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		Arrays.sort(pos);
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(pos[i].x +" " + pos[i].y +"\n");
		}
		
		bw.flush();
		
	}

}

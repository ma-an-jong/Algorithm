package D0902;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//채점에 버그있음 dx dy 배열을 매번 초기화 시켜주지 않거나 0 0 이 입력됬을때 바로 안 끝내면 틀림

public class 섬의개수 {
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			
		int dx[] = {1,1,0,-1,-1,-1, 0, 1};
		int dy[] = {0,1,1, 1, 0,-1,-1,-1};
		
		
		
		String str[] = br.readLine().split(" ");
		
		int w = Integer.parseInt(str[0]);
		int h = Integer.parseInt(str[1]);
		
		if(w == 0 && h == 0) break;
		
		int table[][] = new int[h][w];
		
		
		for(int i = 0 ; i < h;i++) {
			
			str = br.readLine().split(" ");
			
			for(int j = 0; j < w;j++ ) {
				table[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		int cnt = 0;
		
		for(int i = 0 ; i < h;i++) {
			for(int j = 0; j < w ; j++) {
				
				if(table[i][j] != 0) {
				
				qy.add(i); qx.add(j);
				
				table[i][j] = 0;
				
				while(!qx.isEmpty()) {
					
					int x = qx.remove();
					int y = qy.remove();
					
					for(int k = 0 ; k < 8; k++) {
						int mx = x + dx[k];
						int my = y + dy[k];
						
						try {
						
						if(table[my][mx] == 1) {
							qy.add(my); qx.add(mx);
							
							table[my][mx] = 0;
							}
						}
						catch (Exception e) {

						}
					}
					
				}
				
				cnt++;
				
				}
			}
		}
			
	
		bw.write(cnt+"\n");
		bw.flush();
		
		}
		
		
	}
}

package D0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ¾çÄ¡±â_±Ã {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		char table[][] = new char[h][w];
		
		for(int i = 0 ; i < h; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < w ; j++) {
				table[i][j] = s.charAt(j);
			}
		}
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		int K = 0;
		int V = 0;
		
		for(int i = 0 ; i < h; i++) {
			for(int j = 0 ; j < w ; j++) {
				
				if(table[i][j] == 'k' || table[i][j] == 'v' ) {
					
					int vcnt = 0 ; int kcnt = 0;
					
					qx.add(j);
					qy.add(i);
					
					if(table[i][j] == 'k') kcnt++;
					if(table[i][j] == 'v') vcnt++;
					
					table[i][j] = '#';
					
					while(!qx.isEmpty()) {
						
						int x = qx.remove();
						int y = qy.remove();
				
						for(int k = 0; k < 4;k++) {
							int mx = x + dx[k];
							int my = y + dy[k];
						
							try {
								if(table[my][mx] == 'v') {
									qx.add(mx);
									qy.add(my);
									
									table[my][mx] = '#';
									vcnt++;
								}
								else if(table[my][mx] == 'k') {
									qx.add(mx);
									qy.add(my);
									
									table[my][mx] = '#';
									kcnt++;
								}
								else if(table[my][mx] == '.') {
									qx.add(mx);
									qy.add(my);
									
									table[my][mx] = '#';
								}
								
							}
						
							catch (Exception e) {

							}
						

						}
					}
					
					if(kcnt > vcnt) {
						K += kcnt;
					}
					else {
						V += vcnt;
					}
		
				}
				
			}
		}
		
		System.out.print(K + " " + V);
		
	}
}

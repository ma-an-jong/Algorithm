package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호_붙이기 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int table[][] = new int[n][n];
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		for(int i = 0 ; i < n; i++) {
			String str = br.readLine();
			
			for(int j = 0 ; j < n ; j++) {
				char c = str.charAt(j);
				if(c == '1') {
					table[i][j] = 1;
				}
				else {
					table[i][j] = 0;
				}
			}
		}
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		int cnt = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int h = 0; h < n;h++) {
			for(int w = 0 ; w < n ; w++) {

				if(table[h][w] == 1) {
					
					qx.add(w);
					qy.add(h);
					
					table[h][w] = 0;
					
					int house = 1;
					
					while (!qx.isEmpty()) {
						
						int x = qx.remove();
						int y = qy.remove();
						
						for(int i = 0 ; i < 4; i++) {
							
							int mx = x + dx[i];
							int my = y + dy[i];
							
							try {
								if(table[my][mx] == 1) {
									
									qx.add(mx);
									qy.add(my);
									
									table[my][mx] = 0;
									
									house++;
								}
							}
							catch (Exception e) {

							}
						}
		
						
					}
					
					list.add(house);
					cnt++;
					
					
				}	
				
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0 ; i < list.size();i++) {
			bw.write(list.get(i) + "\n");
		}
		
		System.out.println(cnt);
		bw.flush();
		
	}
}

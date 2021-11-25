package Success;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;

public class 안전__영역 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int table[][] = new int[n][n];
		String str[];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(str[j]);
				if (max < table[i][j])
					max = table[i][j];
			}
		}

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		int rain = -1;
		int result = 0;

		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		while (max >= rain) {
			rain++;
			boolean visited[][] = new boolean[n][n];
			int count = 0;
			
			for (int h = 0; h < n; h++) {
				for (int w = 0; w < n; w++) {
					if (!visited[h][w] && rain < table[h][w]) {
						qx.add(w);
						qy.add(h);
						visited[h][w] = true;
						
						while (!qx.isEmpty()) {
							int x = qx.remove();
							int y = qy.remove();

							for (int i = 0; i < 4; i++) {
								try {
									int mx = x + dx[i];
									int my = y + dy[i];

									if (table[my][mx] > rain && !visited[my][mx]) {
										qx.add(mx);
										qy.add(my);
										visited[my][mx] = true;
									}

								} 
								catch (Exception e) {

								}

							}
						}
						count++;
					}
					
				}

			}
			
			if(count > result) result = count;

		}
		
		System.out.println(result);

	}
}

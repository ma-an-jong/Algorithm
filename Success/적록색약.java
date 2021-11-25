package D0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int table[][] = new int[n][n];
		int RGtable[][] = new int[n][n];

		boolean visited[][] = new boolean[n][n];

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		// R == 1, G == 2 , B == 3

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == 'R') {
					table[i][j] = 1;
					RGtable[i][j] = 1;

				} else if (c == 'G') {
					table[i][j] = 2;
					RGtable[i][j] = 1;
				} else {
					table[i][j] = 3;
					RGtable[i][j] = 3;

				}

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		int cnt = 0;

		for (int h = 0; h < n; h++) {
			for (int w = 0; w < n; w++) {

				if (table[h][w] != 0 && !visited[h][w]) {

					qx.add(w);
					qy.add(h);

					while (!qx.isEmpty()) {

						int x = qx.poll();
						int y = qy.poll();

						for (int i = 0; i < 4; i++) {

							int mx = x + dx[i];
							int my = y + dy[i];

							try {
								if (table[my][mx] == table[y][x] && !visited[my][mx]) {

									qx.add(mx);
									qy.add(my);

									visited[my][mx] = true;
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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		int RGcnt = 0;

		for (int h = 0; h < n; h++) {
			for (int w = 0; w < n; w++) {

				if (RGtable[h][w] != 0 && !visited[h][w]) {

					qx.add(w);
					qy.add(h);

					while (!qx.isEmpty()) {

						int x = qx.poll();
						int y = qy.poll();

						for (int i = 0; i < 4; i++) {

							int mx = x + dx[i];
							int my = y + dy[i];

							try {
								if (RGtable[my][mx] == RGtable[y][x] && !visited[my][mx]) {

									qx.add(mx);
									qy.add(my);

									visited[my][mx] = true;
								}
							}

							catch (Exception e) {

							}

						}

					}
					RGcnt++;
				}

			}

		}

		System.out.print(cnt + " " + RGcnt);
	}
}

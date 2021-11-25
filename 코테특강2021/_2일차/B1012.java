package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B1012 {
	public static void BFS(int[][] arr, int w, int h) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		q1.add(w);
		q2.add(h);
		arr[w][h] = 0;

		while (!q1.isEmpty() && !q2.isEmpty()) {
			int x = q1.remove();
			int y = q2.remove();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				try {
					if (arr[nx][ny] == 1) {

						q1.add(nx);
						q2.add(ny);

						arr[nx][ny] = 0;
					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		for (int k = 0; k < count; k++) {
			String str[] = br.readLine().split(" ");
			int w = Integer.parseInt(str[0]);
			int h = Integer.parseInt(str[1]);
			int size = Integer.parseInt(str[2]);
			int matrix[][] = new int[w][h];

			for (int i = 0; i < size; i++) {
				String tmp[] = br.readLine().split(" ");
				matrix[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
			}
		
			
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (matrix[j][i] == 1) {
						BFS(matrix, j, i);
						cnt++;
					}
				}
			}

			bw.write(cnt + "\n");
		
		}
		bw.flush();
	}
}

package ª©ª©∑Œµ•¿Ã;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ∞Ê∑Œ_√£±‚ {

	public static boolean isConnected(ArrayList<Integer> list[], int from, int to) {
		boolean visited[] = new boolean[list.length];
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(from);

		visited[from] = true;

		while (!q.isEmpty()) {
			int v = q.remove();

				for (int j = 0; j < list[v].size(); j++) {
					int a = list[v].get(j);

					if (a == to)
						return true;

					if (!visited[a]) {
						q.add(a);
						visited[a] = true;
					}

				}

		}

		return false;

	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String str[];

		ArrayList<Integer> list[] = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n; i++) {

			str = br.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				if (str[j].equals("1"))
					list[i].add(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = isConnected(list, i, j);

				if (flag) {
					bw.write("1 ");
				} else {
					bw.write("0 ");
				}

			}

			bw.write("\n");
		}

		bw.flush();

	}

}

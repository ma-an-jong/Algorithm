package D0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
	int v;
	int adjv;
	int cost;

	public Vertex(int v, int adjv, int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}
}

public class ¼û¹Ù²ÀÁú3 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);

		int K = Integer.parseInt(str[1]);

		ArrayList<Vertex> list[] = new ArrayList[100001];
		int cost[] = new int[100001];

		for (int i = 0; i <= 100000; i++) {
			list[i] = new ArrayList<Vertex>();
			cost[i] = Integer.MAX_VALUE;
			try {

				if (i - 1 >= 0 && i - 1 <= 100000)
					list[i].add(new Vertex(i, i - 1, 1));
				if (i + 1 >= 0 && i + 1 <= 100000)
					list[i].add(new Vertex(i, i + 1, 1));
				if (i * 2 >= 0 && i * 2 <= 100000)
					list[i].add(new Vertex(i, i * 2, 0));
				
			} catch (Exception e) {

			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> count = new LinkedList<Integer>();

		q.add(N);
		count.add(0);
		cost[N] = 0;

		while (!q.isEmpty()) {

			int pos = q.remove();
			int cnt = count.remove();

			for (int i = 0; i < list[pos].size(); i++) {

				Vertex v = list[pos].get(i);

				if (cost[v.adjv] > cnt + v.cost) {
					cost[v.adjv] = cnt + v.cost;

					q.add(v.adjv);
					count.add(cost[v.adjv]);
				}
			}
		}
		System.out.println(cost[K]);
	}
}

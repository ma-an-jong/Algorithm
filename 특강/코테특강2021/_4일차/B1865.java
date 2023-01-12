package D0826;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Edge {
	int v;
	int adjv;
	int cost;

	public Edge(int v, int adjv, int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}
}

class Vertex implements Comparable<Vertex> {

	int v;
	int sum;

	public Vertex(int v, int sum) {
		this.v = v;
		this.sum = sum;
	}

	public int compareTo(Vertex o) {
		if (this.sum > o.sum) {
			return 1;
		} else if (this.sum == o.sum) {
			return 0;
		} else {
			return -1;
		}
	}
}

public class B1865 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int k = 0; k < tc; k++) {

			String str[] = br.readLine().split(" ");

			int v = Integer.parseInt(str[0]);

			int edge = Integer.parseInt(str[1]);
			int nedge = Integer.parseInt(str[2]);

			ArrayList<Edge> list[] = new ArrayList[v + 1];

			for (int i = 1; i <= v; i++) {
				list[i] = new ArrayList<Edge>();
			}

			for (int i = 1; i <= edge; i++) {
				str = br.readLine().split(" ");

				list[Integer.parseInt(str[0])]
						.add(new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
				list[Integer.parseInt(str[1])]
						.add(new Edge(Integer.parseInt(str[1]), Integer.parseInt(str[0]), Integer.parseInt(str[2])));
			}

			for (int i = 1; i <= nedge; i++) {
				str = br.readLine().split(" ");

				list[Integer.parseInt(str[0])]
						.add(new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), -Integer.parseInt(str[2])));
			}

			int ans[] = new int[v + 1];

			for (int i = 1; i <= v; i++) {
				ans[i] = Integer.MAX_VALUE;
			}
			ans[1] = 0;
			boolean flag = false;
			for (int i = 1; i <= v; i++) {

				for (int j = 0; j < list[i].size(); j++) {
					Edge e = list[i].get(j);

					if (ans[e.adjv] > ans[e.v] + e.cost) {
						ans[e.adjv] = ans[e.v] + e.cost;
					}
				}
				
			}


			if (flag) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		bw.flush();
	}
}

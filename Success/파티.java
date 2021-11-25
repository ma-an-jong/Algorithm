package D0909;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
	int adjv;
	int cost;

	public Edge(int adjv, int cost) {
		this.adjv = adjv;
		this.cost = cost;
	}

	public int compareTo(Edge o) {
		if (this.cost > o.cost)
			return 1;
		else if (this.cost == o.cost)
			return 0;
		else
			return -1;
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
		if (this.sum > o.sum)
			return 1;
		else if (this.sum == o.sum)
			return 0;
		else
			return -1;
	}
}

public class 파티 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int x = Integer.parseInt(str[2]);

		ArrayList<Edge> list[] = new ArrayList[n + 1];
		int time[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");

			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			int Ti = Integer.parseInt(str[2]);

			list[A].add(new Edge(B, Ti));
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		int memo[] = new int[n+1];
		
		for (int k = 1; k <= n; k++) {
			
			if(k == x) continue;
			
			pq.add(new Vertex(k, 0));

			for (int i = 1; i <= n; i++) {
				time[i] = Integer.MAX_VALUE;
			}

			time[k] = 0;

			while (!pq.isEmpty()) {

				Vertex vertex = pq.remove();

				for (int i = 0; i < list[vertex.v].size(); i++) {
					Edge e = list[vertex.v].get(i);

					if (time[e.adjv] > time[vertex.v] + e.cost) {
						time[e.adjv] = time[vertex.v] + e.cost;
						pq.add(new Vertex(e.adjv, time[e.adjv]));
					}
				}

			}
			
			memo[k] = time[x];
		}
		
		//돌아가기
		pq.add(new Vertex(x, 0));

		for (int i = 1; i <= n; i++) {
			time[i] = Integer.MAX_VALUE;
		}

		time[x] = 0;

		while (!pq.isEmpty()) {

			Vertex vertex = pq.remove();

			for (int i = 0; i < list[vertex.v].size(); i++) {
				Edge e = list[vertex.v].get(i);

				if (time[e.adjv] > time[vertex.v] + e.cost) {
					time[e.adjv] = time[vertex.v] + e.cost;
					pq.add(new Vertex(e.adjv, time[e.adjv]));
				}
			}

		}
		
		
		int sum = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n ; i++) {
			if(sum < memo[i] + time[i]) {
				sum = memo[i] + time[i];
			}
		}
		
		System.out.println(sum);

	}
}

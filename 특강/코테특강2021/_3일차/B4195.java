package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

class Point {
	int v;
	double x;
	double y;

	Point(int v, double x, double y) {
		this.v = v;
		this.x = x;
		this.y = y;
	}
}

public class B4195 implements Comparable<B4195> {
	int v;
	int adjv;
	double cost;

	public B4195(int v, int adjv, double cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}

	public int compareTo(B4195 o) {
		if (this.cost > o.cost)
			return 1;
		else if (this.cost == o.cost)
			return 0;
		else
			return -1;
	}

	public static int findset(int data[], int p) {
		if (p == data[p])
			return p;
		data[p] = findset(data, data[p]);
		return data[p];
	}

	public static void unionset(int data[], int a, int b) {
		int ap = findset(data, a);
		int bp = findset(data, b);
		data[ap] = bp;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int v = Integer.parseInt(br.readLine());

		String str[];

		int data[] = new int[v];

		for (int i = 0; i < v; i++) {
			data[i] = i;
		}

		Point p[] = new Point[v];

		ArrayList<B4195> list = new ArrayList<B4195>();

		for (int i = 0; i < v; i++) {
			str = br.readLine().split(" ");

			double x = Double.parseDouble(str[0]);
			double y = Double.parseDouble(str[1]);

			p[i] = new Point(i, x, y);
		}

		for (int i = 0; i < v ; i++) {
			for (int j = 0; j < v; j++) {
				if(i == j) continue;
				double w = Math.abs(p[i].x - p[j].x);
				double h = Math.abs(p[i].y - p[j].y);

				double cost = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));

				list.add(new B4195(i, j, cost));
			}
		}

		Collections.sort(list);
		
		double result = 0.0;

		for (int i = 0; i < list.size(); i++) {
			B4195 o = list.get(i);
			if (findset(data, o.v) != findset(data, o.adjv)) {
				result += o.cost;
				unionset(data, o.v, o.adjv);
			}

		}

		bw.write(result + "");
		bw.flush();

	}
}

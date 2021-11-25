package D0825;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Vertex {
	int v;
	int x;
	int y;
	int z;

	public Vertex(int v, int x, int y, int z) {
		this.v = v;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int adjv;
	int cost;

	public Edge(int v, int adjv,int cost) {
		this.v = v;
		this.adjv = adjv;
		this.cost = cost;
	}

	public int compareTo(Edge o) {
		if (this.cost > o.cost) {
			return 1;
		} else if (this.cost == o.cost) {
			return 0;
		} else {
			return -1;
		}
	}
}

public class B2887 {
	
	public static int findset(int data[],int p) {
		if(p == data[p])
			return p;
		data[p] = findset(data, data[p]);
		return data[p];
	}
	
	public static void unionset(int data[],int a,int b) {
		int ap = findset(data, a);
		int bp = findset(data, b);
		data[ap] = bp; 
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Vertex data[] = new Vertex[n];

		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			data[i] = new Vertex(i, Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		}

		int cost = 0;
		

		PriorityQueue<Edge> edge = new PriorityQueue<Edge>();
		
		
		Arrays.sort(data,new Comparator<Vertex>() {
			public int compare(Vertex v, Vertex adjv) {
				return Integer.compare(v.x, adjv.x);
			}
		}
				);
		
		for (int j = 1; j < n; j++) {
			int c = Math.min(Math.min(Math.abs(data[j].x - data[j-1].x),Math.abs(data[j].y - data[j-1].y)),Math.abs(data[j].z - data[j-1].z));
			edge.add(new Edge(data[j].v,data[j-1].v,c));
		}
		
		
		
		Arrays.sort(data,new Comparator<Vertex>() {
			public int compare(Vertex v, Vertex adjv) {
				return Integer.compare(v.y, adjv.y);
			}
		}
				);
		
		
		for (int j = 1; j < n; j++) {
			int c = Math.min(Math.min(Math.abs(data[j].x - data[j-1].x),Math.abs(data[j].y - data[j-1].y)),Math.abs(data[j].z - data[j-1].z));
			edge.add(new Edge(data[j].v,data[j-1].v,c));
		}
		
		
		Arrays.sort(data,new Comparator<Vertex>() {
			public int compare(Vertex v, Vertex adjv) {
				return Integer.compare(v.z, adjv.z);
			}
		}
				);
		
		
		for (int j = 1; j < n; j++) {
			int c = Math.min(Math.min(Math.abs(data[j].x - data[j-1].x),Math.abs(data[j].y - data[j-1].y)),Math.abs(data[j].z - data[j-1].z));
			edge.add(new Edge(data[j].v,data[j-1].v,c));
		}
		
		int data1[] = new int[n];

		for(int i = 0 ; i < n;i++) {
			data1[i] = i;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < edge.size(); j++) {
				Edge e = edge.remove();

				int v = findset(data1, e.v);
				int adjv = findset(data1, e.adjv);

				if (v != adjv) {
					unionset(data1, e.v, e.adjv);
					cost += e.cost;
					break;
				}
			}
		}
		System.out.println(cost);
	}
}

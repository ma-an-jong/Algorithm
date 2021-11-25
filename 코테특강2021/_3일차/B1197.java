package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1197 implements Comparable<B1197> {

	int to;
	int from;
	int cost;

	@Override
	public int compareTo(B1197 o) {
		if (o.cost < this.cost) {
			return 1;
		} else if (o.cost == this.cost) {
			return 0;
		}
		else 
			return -1;
	}

	public B1197(int to, int from, int cost) {
		this.to = to;
		this.from = from;
		this.cost = cost;
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

		String str[] = br.readLine().split(" ");

		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);

		int data[] = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			data[i] = i;
		}

		B1197 arr[] = new B1197[e];

		for (int i = 0; i < e; i++) {
			str = br.readLine().split(" ");
			arr[i] = new B1197(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = 0 ; i < e;i++) {
			
			if(findset(data,arr[i].to) != findset(data, arr[i].from)){
				unionset(data,arr[i].to,arr[i].from);
				cnt += arr[i].cost;
			}			
		}
		bw.write(cnt+"");
		bw.flush();

	}
}

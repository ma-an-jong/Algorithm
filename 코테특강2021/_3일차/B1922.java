package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1922 implements Comparable<B1922> {

	int to;
	int from;
	int cost;
	
	public int compareTo(B1922 o) {
		if(this.cost > o.cost) {
			return 1;
		}
		else if(this.cost == o.cost) {
			return 0;
		}
		else 
			return -1;
	}
	
	public B1922(int to,int from , int cost) {
		this.to = to;
		this.from = from;
		this.cost = cost;
	}
	
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		int data[] = new int[v +1];
		B1922 arr[] = new B1922[e];
		
		for(int i = 1 ; i <= v;i++) {
			data[i]=i;
		}
		
		String str[];
		for(int i = 0 ; i < e;i++) {
			str = br.readLine().split(" ");
			int to = Integer.parseInt(str[0]);
			int from = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			
			arr[i] = new B1922(to,from, cost);
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for(int i = 0; i < e;i++) {
			
			int a = arr[i].to;
			int b =  arr[i].from;
			if(findset(data, a) != findset(data,b)) {
				unionset(data, a,b );
				cnt += arr[i].cost;
			}
		}
		
		
		bw.write(cnt+"");
		bw.flush();
		
	}
}

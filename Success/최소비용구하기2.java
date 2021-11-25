package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Bus implements Comparable<Bus>{
	
	int adjv;
	int cost;
	ArrayList<Integer> seqNum;
	
	public Bus(int adjv,int cost,ArrayList<Integer> seqNum) {
		this.adjv = adjv;
		this.cost = cost;
		this.seqNum = seqNum;
	}
	
	public int compareTo(Bus o) {
		return this.cost - o.cost;
	}
	
}

public class 최소비용구하기2 {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m  = Integer.parseInt(br.readLine());
		
		ArrayList<Bus> list[] = new ArrayList[n+1];
		ArrayList<Integer> seq[] = new ArrayList[n+1];
		
		for(int i = 0 ; i <= n; i++ ) {
			list[i] = new ArrayList<Bus>();
			seq[i] = new ArrayList<Integer>();
		}
		
		String str[];
		for(int i = 0 ; i < m;i++) {
			str = br.readLine().split(" ");
			
			list[Integer.parseInt(str[0])].add(new Bus(Integer.parseInt(str[1]),Integer.parseInt(str[2]),null));
			
		}
		
		str = br.readLine().split(" ");
		
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		
		pq.add(new Bus(start,0,new ArrayList<Integer>()));
		
		int distance[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		
		for(int i = 0; i <= n;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[start] = 0;

		while(!pq.isEmpty()) {
			
			Bus bus = pq.remove();
			
			int adjv = bus.adjv;
			int cost = bus.cost;
			
			
			if(distance[adjv] < cost) {
				continue;
			}
			
			visited[adjv] = true;
			
			for(int i = 0 ; i < list[adjv].size();i++) {
				Bus b = list[adjv].get(i);
				
				if(!visited[b.adjv] && distance[b.adjv] > cost + b.cost) {
					distance[b.adjv] = cost + b.cost;
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					
					
					for(int j = 0 ; j < bus.seqNum.size();j++) {
						tmp.add(bus.seqNum.get(j));
					}
					
					tmp.add(adjv);
					seq[b.adjv] = tmp;
					pq.add(new Bus(b.adjv,distance[b.adjv],seq[b.adjv]));
					
				}
			}

		}
		
		bw.write(distance[end]+"\n");
		bw.write(seq[end].size() + 1 + "\n");
		for(int i = 0 ; i < seq[end].size(); i++) {
			bw.write(seq[end].get(i)+" ");
		}
		bw.write(end +"\n");

		bw.flush();
		
		
	}

}

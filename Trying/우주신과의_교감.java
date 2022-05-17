package Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 우주신과의_교감 {
	
	static class Vertex{
		int index;
		long x;
		long y;
		
		Vertex(int index,long x,long y){
			this.index = index;
			this.x = x;
			this.y = y;
		}	
	}
	
	static class Edge implements Comparable<Edge>
	{
		Vertex v; //정점
		Vertex adjv; // 반대정점
		double distance;
		
		Edge(Vertex v,Vertex adjv)
		{
			this.v = v;
			this.adjv = adjv;
		
			distance = 
					Math.sqrt(Math.pow(v.x-adjv.x,2) + Math.pow(v.y-adjv.y,2));
			
		}

		@Override
		public int compareTo(Edge o) {
			
			if(distance > o.distance)
			{
				return 1;
			}
			else if(distance == o.distance)
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
	}

	static int find(int[] arr,int a)
	{
		if(arr[a] == a)
		{
			return a;
		}
		
		arr[a] = find(arr,arr[a]);
		return arr[a];
	}
	
	static void union(int[] arr , int a, int b)
	{
		int ap = find(arr,a);
		int bp = find(arr,b);
		arr[ap] = bp;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]); // 총 정점의 개수
		int M = Integer.parseInt(str[1]); // 이미 연결되어있는 간선의 개수
		
		List<Vertex> list = new ArrayList<Vertex>(); // 정점을 저장하고있는 리스트
		int arr[] = new int[N+1]; //union-find 배열
		
		for(int i = 0 ; i < N; i++)
		{
			arr[i] = i;
			str = br.readLine().split(" ");
			
			long x = Long.parseLong(str[0]);
			long y = Long.parseLong(str[1]);
			
			list.add(new Vertex(i+1,x,y));
		}
		
		arr[N] = N;
		
		// 이미 연결된 간선을 계산할때 
		for(int i = 0; i < M ; i++)
		{
			str = br.readLine().split(" ");
			
			int v = Integer.parseInt(str[0]); //정점1
			int adjv = Integer.parseInt(str[1]); //정점2
			
			union(arr,v,adjv); // 정점1 과 정점2 를 연결
		}
		// 최소 신장트리 만들때 => 정렬, 우선순위큐
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 0 ; i < list.size();i++) //간선을 생성 각 정점에서부터 이동 가능한 간선을 모두 계산해서 우선순위큐에 삽입함
		{
			Vertex v = list.get(i);
			for(int j = i+1; j < list.size();j++)
			{
				Vertex adjv = list.get(j);
				
				if(find(arr,v.index) != find(arr,adjv.index)) //정점 2개가 이미 연결되어있지않으면 => 간선을 새로 생성
				{
					pq.add(new Edge(v, adjv));
				}
				
			}
		}
		
		
		//새로 생성해야하는 통로의 길이를 저장
		double sum = 0.00;
		
		//모든 간선을 탐색할때 까지
		while(!pq.isEmpty())
		{
			Edge edge = pq.remove();
			
			if(find(arr,edge.v.index) != find(arr,edge.adjv.index)) //간선이 이미 존재하지않는다.
			{
				sum += edge.distance;
				union(arr, edge.v.index, edge.adjv.index);
			}
		}
		
		System.out.printf("%.2f", (double) Math.round(sum * 100) / 100);
		

	}
	
	
	
}

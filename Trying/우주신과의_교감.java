package Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ���ֽŰ���_���� {
	
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
		Vertex v; //����
		Vertex adjv; // �ݴ�����
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
		
		int N = Integer.parseInt(str[0]); // �� ������ ����
		int M = Integer.parseInt(str[1]); // �̹� ����Ǿ��ִ� ������ ����
		
		List<Vertex> list = new ArrayList<Vertex>(); // ������ �����ϰ��ִ� ����Ʈ
		int arr[] = new int[N+1]; //union-find �迭
		
		for(int i = 0 ; i < N; i++)
		{
			arr[i] = i;
			str = br.readLine().split(" ");
			
			long x = Long.parseLong(str[0]);
			long y = Long.parseLong(str[1]);
			
			list.add(new Vertex(i+1,x,y));
		}
		
		arr[N] = N;
		
		// �̹� ����� ������ ����Ҷ� 
		for(int i = 0; i < M ; i++)
		{
			str = br.readLine().split(" ");
			
			int v = Integer.parseInt(str[0]); //����1
			int adjv = Integer.parseInt(str[1]); //����2
			
			union(arr,v,adjv); // ����1 �� ����2 �� ����
		}
		// �ּ� ����Ʈ�� ���鶧 => ����, �켱����ť
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 0 ; i < list.size();i++) //������ ���� �� ������������ �̵� ������ ������ ��� ����ؼ� �켱����ť�� ������
		{
			Vertex v = list.get(i);
			for(int j = i+1; j < list.size();j++)
			{
				Vertex adjv = list.get(j);
				
				if(find(arr,v.index) != find(arr,adjv.index)) //���� 2���� �̹� ����Ǿ����������� => ������ ���� ����
				{
					pq.add(new Edge(v, adjv));
				}
				
			}
		}
		
		
		//���� �����ؾ��ϴ� ����� ���̸� ����
		double sum = 0.00;
		
		//��� ������ Ž���Ҷ� ����
		while(!pq.isEmpty())
		{
			Edge edge = pq.remove();
			
			if(find(arr,edge.v.index) != find(arr,edge.adjv.index)) //������ �̹� ���������ʴ´�.
			{
				sum += edge.distance;
				union(arr, edge.v.index, edge.adjv.index);
			}
		}
		
		System.out.printf("%.2f", (double) Math.round(sum * 100) / 100);
		

	}
	
	
	
}

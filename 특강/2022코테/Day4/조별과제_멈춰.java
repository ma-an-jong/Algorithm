package Day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 조별과제_멈춰 {
    static class Edge implements Comparable<Edge>{
        int v;
        int adjv;
        int cost;

        Edge(int v,int adjv,int cost)
        {
            this.v = v;
            this.adjv = adjv;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int find(int[] arr, int a)
    {
        if(arr[a] == a)
        {
            return a;
        }

        int ap = find(arr,arr[a]);
        arr[a] = ap;
        return ap;
    }

    static void union(int[] arr, int a,int b)
    {
        int ap = find(arr,a);
        int bp = find(arr,b);
        if(ap != bp)
        {
            arr[ap] = bp;
        }

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        ArrayList<Edge> mst[] = new ArrayList[N+1];

        int arr[] = new int[N+1];

        for(int i = 1 ; i <= N;i++)
        {
            mst[i] = new ArrayList<>();
            arr[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        for(int i = 0 ; i < M ; i++)
        {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            pq.add(new Edge(a,b,c));
        }

        int count = 0;
        while(count < N-1)
        {
            Edge e = pq.remove();

            if(find(arr,e.v) != find(arr,e.adjv))
            {
                union(arr,e.v,e.adjv);
                mst[e.v].add(new Edge(e.v,e.adjv,e.cost));
                mst[e.adjv].add(new Edge(e.adjv,e.v,e.cost));
                count++;
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < Q;i++)
        {
            str= br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            boolean visited[] = new boolean[N+1];

            visited[a] = true; visited[b] = true;

            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

            for(int j = 0 ; j < mst[a].size();j++)
            {
                Edge e = mst[a].get(j);
                priorityQueue.add(new Edge(e.v,e.adjv,e.cost));
            }
            for(int j = 0 ; j < mst[b].size();j++)
            {
                Edge e = mst[b].get(j);
                priorityQueue.add(new Edge(e.v,e.adjv,e.cost));
            }


            int sum = 0;

            while(!priorityQueue.isEmpty())
            {
                Edge pos = priorityQueue.remove();

                if(!visited[pos.adjv])
                {
                    visited[pos.adjv] = true;
                    sum += pos.cost;

                    for(int k = 0 ; k < mst[pos.adjv].size();k++)
                    {
                        Edge edge = mst[pos.adjv].get(k);
                        priorityQueue.add(new Edge(edge.v,edge.adjv,edge.cost));
                    }
                }
            }

            bw.write(sum+"\n");

        }

        bw.flush();

    }
}

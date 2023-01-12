package Day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 최단경로 {
    static class Edge{
        int v;
        int adjv;
        int cost;

        Edge(int v,int adjv,int cost)
        {
            this.v = v;
            this.adjv = adjv;
            this.cost = cost;
        }

    }

    static class Position implements Comparable<Position>{

        int pos;
        int cost;

        Position(int pos,int cost)
        {
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_value = 1000000;

        String str[] = br.readLine().split(" ");

        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);

        int start = Integer.parseInt(br.readLine());

        ArrayList<Edge> graph[] = new ArrayList[V+1];
        int cost[] = new int[V+1];
        boolean visited[] = new boolean[V+1];

        for(int i = 1; i <= V;i++)
        {
            graph[i] = new ArrayList<Edge>();
            cost[i] = max_value;
        }

        for(int i = 0 ; i < E ; i++)
        {
            str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int adjv = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            graph[v].add(new Edge(v,adjv,c));
        }

        PriorityQueue<Position> pq = new PriorityQueue<Position>();

        pq.add(new Position(start,0));
        cost[start] = 0;

        while(!pq.isEmpty())
        {
            Position position = pq.remove();

            if(position.cost > cost[position.pos] || visited[position.pos]) continue;

            for(int i = 0 ; i < graph[position.pos].size();i++)
            {
                Edge edge = graph[position.pos].get(i);

                if(cost[edge.adjv] > position.cost + edge.cost)
                {
                    cost[edge.adjv] = position.cost + edge.cost;
                    pq.add(new Position(edge.adjv,cost[edge.adjv]));
                }
            }
        }

        for(int i =1; i <=V;i++)
        {
            bw.write(cost[i] == max_value ? "INF\n" : cost[i] + "\n");
        }

        bw.flush();



    }
}

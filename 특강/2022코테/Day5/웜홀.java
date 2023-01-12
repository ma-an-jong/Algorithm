package Day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 웜홀 {

    static class Edge
    {
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
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t<testcase;t++)
        {

            String str[] = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int W = Integer.parseInt(str[2]);

            ArrayList<Edge> graph = new ArrayList();

            for(int i = 0 ; i < M;i++)
            {
                str = br.readLine().split(" ");
                int v = Integer.parseInt(str[0]);
                int adjv = Integer.parseInt(str[1]);
                int cost  =Integer.parseInt(str[2]);

                graph.add(new Edge(v,adjv,cost));
                graph.add(new Edge(adjv,v,cost));
            }

            for(int i = 0 ; i < W;i++)
            {
                str = br.readLine().split(" ");
                int v = Integer.parseInt(str[0]);
                int adjv = Integer.parseInt(str[1]);
                int cost  =Integer.parseInt(str[2]);

                graph.add(new Edge(v,adjv,-cost));
            }

            int cost[] = new int[N+1];
            int max = 1000*10000;
            Arrays.fill(cost,max);


            for(int i = 1; i <=N;i++)
            {
                for(int j = 0 ; j < graph.size();j++)
                {
                    Edge edge = graph.get(j);

                    if(cost[edge.adjv] > edge.cost + cost[edge.v])
                    {
                        cost[edge.adjv] = edge.cost + cost[edge.v];
                    }
                }
            }

            boolean flag = false;
            for(int i = 1; i <=N;i++)
            {
                if(flag) break;
                for(int j = 0 ; j < graph.size();j++)
                {
                    Edge edge = graph.get(j);

                    if(cost[edge.adjv] > edge.cost + cost[edge.v])
                    {
                        flag = true;
                        break;
                    }

                }
            }

            if(flag) bw.write("YES\n");
            else bw.write("NO\n");

        }

        bw.flush();
    }
}
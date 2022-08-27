package Day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 타임머신 {

    static class Edge{
        int v;
        int adjv;
        long cost;

        Edge(int v,int adjv,long cost)
        {
            this.v = v;
            this.adjv = adjv;
            this.cost = cost;
        }

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        ArrayList<Edge> list = new ArrayList<Edge>();

        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int adjv = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);

            list.add(new Edge(v,adjv,cost));
        }
        long cost[] = new long[N+1];

        long max = 10000*10000;
        Arrays.fill(cost,max);
        cost[1] = 0;

        for(int i = 1; i <= N;i++)
        {
            for(int j = 0 ; j < list.size();j++)
            {
                Edge e = list.get(j);
                if(cost[e.adjv] > cost[e.v] + e.cost)
                {
                    cost[e.adjv] = cost[e.v] + e.cost;
                }
            }
        }
        boolean flag = false;

        for(int i = 1; i <= N;i++)
        {
            if(flag) break;
            for(int j = 0 ; j < list.size();j++)
            {
                Edge e = list.get(j);
                if(cost[e.adjv] > cost[e.v] + e.cost && cost[e.adjv] != max)
                {
                    flag = true;
                    break;
                }
            }
        }

        if(flag)
        {
            bw.write("-1\n");
        }
        else
        {
            for(int i = 2; i <= N;i++)
            {
                if(cost[i] >= max)
                {
                    bw.write("-1\n");
                }
                else
                {
                    bw.write(cost[i] + "\n");
                }
            }
        }


        bw.flush();

//        System.out.println(500+" "+ 500);
//        for(int i = 1; i < 500;i++)
//        {
//            System.out.println(i + " " + (i+1) + " -10000");
//        }
//        System.out.println("500 1 -10000");
    }
}

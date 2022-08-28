package Day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 오민식의_고민 {
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

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int start = Integer.parseInt(str[1]);
        int end = Integer.parseInt(str[2]);
        int M = Integer.parseInt(str[3]);

        ArrayList<Edge> list = new ArrayList<>();

        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");

            int v = Integer.parseInt(str[0]);
            int adjv = Integer.parseInt(str[1]);
            long cost = Long.parseLong(str[2]);

            list.add(new Edge(v,adjv,-cost));
        }

        str =  br.readLine().split(" ");

        int add[] = new int[N];


        for(int i=0 ; i < N;i++)
        {
            add[i] = Integer.parseInt(str[i]);
        }


        long ans[] = new long[N];
        int init = -1000000*50*2;
        Arrays.fill(ans,init);

        ans[start] = add[start];

        for(int i =0 ; i < N;i++)
        {
            for(int j = 0 ; j < list.size();j++)
            {
                Edge edge = list.get(j);

                if(ans[edge.v] == init) continue;
                else if(ans[edge.adjv] < ans[edge.v] + edge.cost + add[edge.adjv])
                {
                    ans[edge.adjv] = ans[edge.v] + edge.cost + add[edge.adjv];
                }
            }
        }

        for(int i =0 ; i < N;i++)
        {
            for(int j = 0 ; j < list.size();j++)
            {
                Edge edge = list.get(j);

                if(ans[edge.v] == init) continue;
                else if(ans[edge.v] == -init) ans[edge.adjv] = -init;
                else if(ans[edge.adjv] < ans[edge.v] + edge.cost + add[edge.adjv])
                {
                    ans[edge.adjv] = -init;
                }
            }
        }

        if(ans[end] == -init)
        {
            System.out.println("Gee");
        }
        else if(ans[end] == init)
        {
            System.out.println("gg");
        }
        else
        {
            System.out.println(ans[end]);
        }


    }
}

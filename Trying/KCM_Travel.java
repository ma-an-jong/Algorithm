package src.Trying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KCM_Travel {

    public static void main(String args[]) throws Exception {

        class Position implements Comparable<Position>{

            int index;
            int costSum;
            int requiredTimeSum;

            public Position(int index,int costSum,int requiredTimeSum)
            {
                this.index = index;
                this.costSum = costSum;
                this.requiredTimeSum = requiredTimeSum;
            }

            @Override
            public int compareTo(Position o)
            {
                if(requiredTimeSum != o.requiredTimeSum)
                {
                    return requiredTimeSum - o.requiredTimeSum;
                }
                else
                {
                    return costSum - o.costSum;
                }
            }
        }

        class Edge{

            int start;
            int end;
            int cost;
            int requiredTime;

            public Edge(int start,int end,int cost,int requiredTime)
            {
                this.start = start;
                this.end = end;
                this.cost = cost;
                this.requiredTime = requiredTime;
            }

        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++)
        {
            String str[] = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);


            ArrayList<Edge>[] graph = new ArrayList[N+1];

            for(int i = 1; i <= N ; i++)
            {
                graph[i] = new ArrayList<Edge>();
            }

            for(int i = 1; i <= k;i++)
            {
                str = br.readLine().split(" ");

                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                int cost = Integer.parseInt(str[2]);
                int requiredTime = Integer.parseInt(str[3]);

                graph[start].add(new Edge(start,end,cost,requiredTime));

            }

            int answer = Integer.MAX_VALUE;

            PriorityQueue<Position> pq = new PriorityQueue<>();

            pq.add(new Position(1,0,0));

            int ans[] = new int[N+1];

            for(int i = 1; i <= N;i++)
            {
                ans[i] = Integer.MAX_VALUE;
            }

            while(!pq.isEmpty())
            {
                Position position = pq.remove();

                if(position.costSum > M) continue;
                if(position.index == N) continue;

                for(int j = 0; j < graph[position.index].size();j++)
                {
                    Edge edge = graph[position.index].get(j);

                    if(position.requiredTimeSum + edge.requiredTime <= ans[edge.end] && edge.cost + position.costSum <= M)
                    {
                        ans[edge.end] = position.requiredTimeSum + edge.requiredTime;
                        pq.add(new Position(edge.end, position.costSum + edge.cost, ans[edge.end]));
                    }
                }

            }

            if(ans[N] == Integer.MAX_VALUE)
            {
                bw.write("Poor KCM\n");
            }
            else
            {
                bw.write(ans[N] + "\n");

            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}

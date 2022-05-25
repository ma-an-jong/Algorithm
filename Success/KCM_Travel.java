package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KCM_Travel {

   static class Edge implements Comparable<Edge>{

        int end;
        int cost;
        int requiredTime;

        public Edge(int end,int cost,int requiredTime)
        {
            this.end = end;
            this.cost = cost;
            this.requiredTime = requiredTime;
        }

       @Override
       public int compareTo(Edge o) {
           return requiredTime - o.requiredTime;
       }

   }
    public static void main(String args[]) throws Exception {

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

                graph[start].add(new Edge(end,cost,requiredTime));

            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            pq.add(new Edge(1,0,0));

            int ans[][] = new int[N+1][M+1];

            for(int i = 0 ; i <=N ; i++)
                Arrays.fill(ans[i],Integer.MAX_VALUE);

            while(!pq.isEmpty())
            {
                Edge position = pq.remove();

                if(position.end == N) break;
                if(ans[position.end][position.cost] < position.requiredTime) continue;

                for(int j = 0; j < graph[position.end].size();j++)
                {
                    Edge edge = graph[position.end].get(j);

                    int newCost = edge.cost + position.cost;
                    int takeTime = position.requiredTime + edge.requiredTime;

                    if(newCost <= M)
                    {
                        if(takeTime < ans[edge.end][newCost]) {
                            for(int i = newCost; i <= M; i++){
                                if(ans[edge.end][i] > takeTime){
                                    ans[edge.end][i] = takeTime;
                                }
                            }
                            ans[edge.end][newCost] = takeTime;
                            pq.add(new Edge(edge.end, newCost, takeTime ));
                        }


                    }
                }

            }
            int answer = Integer.MAX_VALUE;

            for(int i = 0 ; i <= M;i++){
                answer = Integer.min(answer,ans[N][i]);
            }

            if(answer != Integer.MAX_VALUE) bw.write(answer + "\n");
            else bw.write("Poor KCM\n");

        }

        bw.flush();
    }
}

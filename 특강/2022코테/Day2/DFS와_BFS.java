package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와_BFS {

    static ArrayList<Integer> graph[];


    static void dfs(int start) throws Exception
    {
        visited[start] = true;
        bw.write(start+" ");

        for(int i = 0 ; i < graph[start].size();i++)
        {
            int v = graph[start].get(i);
            if(!visited[v])
            {
                dfs(v);
            }
        }

    }

    static void bfs(int start) throws Exception{
        Queue<Integer> q = new LinkedList<>();

        boolean isvisited[] = new boolean[graph.length];

        q.add(start);
        isvisited[start] = true;
        bw.write(start+" ");

        while(!q.isEmpty())
        {
            int node = q.remove();

            for(int i = 0 ; i < graph[node].size();i++)
            {
                int next = graph[node].get(i);

                if(!isvisited[next])
                {
                    q.add(next);
                    isvisited[next] = true;
                    bw.write(next+" ");
                }
            }
        }


    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean visited[];

    public static void main(String args[]) throws Exception {



        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++)
        {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0 ; i <= N; i++)
        {
            Collections.sort(graph[i]);
        }

        dfs(V);
        bw.write("\n");
        bfs(V);



        bw.flush();








    }
}

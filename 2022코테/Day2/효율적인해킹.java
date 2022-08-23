package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 효율적인해킹 {

    static ArrayList<Integer> graph[];
    static int visited[];
    static String str[];

    private static void bfs(int node) {
        visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        visited[node] = 1;
        while (queue.isEmpty() == false) {
            node = queue.remove();
            for (int next : graph[node]) {
                if (visited[next] == 0) {
                    ans[next]++;
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
    }

    static int N;
    static int M;
    static int ans[];


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);


        graph = new ArrayList[N+1];

        for(int i = 0 ; i < N+1;i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i ++)
        {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
        }

        ans = new int[N+1];

        for(int i = 1; i <=N;i++)
        {
            bfs(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < ans.length;i++)
        {
            max = Math.max(max,ans[i]);
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < ans.length;i++)
        {
            if(max == ans[i])
            {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString().trim());


    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 서울_지하철_2호선 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] isCycle;

    static void dfs(int v, int start,boolean[] visited,int count) {
        for (int i = 0; i < graph[v].size(); i++) {
            int adjv = graph[v].get(i);

            if(!visited[adjv]) {
                visited[adjv] = true;
                dfs(adjv,start,visited,count+1);
            }

            if(adjv == start && count > 2) {
                isCycle[start] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        isCycle = new boolean[N+1];
        for (int i = 0; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,i,visited,1);
        }


        for (int i = 1; i <= N; i++) {

            boolean[] visited = new boolean[N+1];

            Queue<Integer> q = new ArrayDeque<>();
            Queue<Integer> c = new ArrayDeque<>();

            q.add(i);
            c.add(0);

            int count = 0;
            int ans = Integer.MAX_VALUE;

            while(!q.isEmpty()) {
                int v = q.remove();
                int cost = c.remove();

                if(isCycle[v]) {
                    ans = Math.min(ans,cost);
                }

                for (int j = 0; j < graph[v].size(); j++) {
                    int adjv = graph[v].get(j);

                    if(!visited[adjv]){
                        visited[adjv] = true;
                        q.add(adjv);
                        c.add(cost+1);
                    }
                }
            }

            bw.write(ans + " ");
        }

        bw.flush();
    }
}

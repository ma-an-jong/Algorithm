package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 트리의_지름 {
    static int N;
    static List<Node>[] graph;
    static int ans = Integer.MIN_VALUE;
    static class Node {
        int adjv;
        int w;

        Node(int adjv, int w){
            this.adjv = adjv;
            this.w = w;
        }

    }

    static void dfs(int v,boolean[] visited,int sum){

        for (int i = 0; i < graph[v].size(); i++) {
            Node adjv = graph[v].get(i);
            if(!visited[adjv.adjv]) {
                ans = Math.max(ans,sum + adjv.w);
                visited[adjv.adjv] = true;
                dfs(adjv.adjv,visited,sum + adjv.w);
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int adjv = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);

            graph[v].add(new Node(adjv,w));
            graph[adjv].add(new Node(v,w));
        }


        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,visited,0);
        }


        System.out.println(ans);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 트리의_지름_1167 {
    static int N;
    static ArrayList<Node>[] tree;

    static class Node {
        int index;
        int w;

        Node(int index,int w){
            this.index = index;
            this.w = w;
        }
    }
    static int max=0;
    static int node;

    static void dfs(int v,boolean[] visited,int sum) {

        if(sum > max) {
            max = sum;
            node = v;
        }

        for (int i = 0; i < tree[v].size(); i++) {
            Node adjv =tree[v].get(i);

            if(!visited[adjv.index]) {
                visited[adjv.index] = true;
                dfs(adjv.index,visited,sum + adjv.w);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            int parent = Integer.parseInt(str[0]);

            for (int j = 1; j < str.length; j+=2) {
                int adjv = Integer.parseInt(str[j]);
                if(adjv != -1) {
                    int w = Integer.parseInt(str[j+1]);
                    tree[parent].add(new Node(adjv,w));
                    tree[adjv].add(new Node(parent,w));
                }
            }
        }

        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,visited,0);
        Arrays.fill(visited,false);
        visited[node] = true;
        max = 0;
        dfs(node,visited,0);

        System.out.println(max);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DFS_스페셜_저지 {
    static int N;
    static List<Integer>[] graph;
    static int[] ans;
    static int[] prior;

    static boolean flag = true;

    static int dfs(int v,int index) {

        if(index == N) {
            flag = false;
            return N;
        }

        for (int i = 0; i < graph[v].size(); i++) {

            int adjv = graph[v].get(i);

            if(ans[index] == adjv && flag){
                index = dfs(adjv,index+1);
            }
        }

        return index;
    }

    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        ans = new int[N];
        prior = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        String[] str;

        for (int i = 0; i < N-1; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(str[i]);
            prior[ans[i]] = i;
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return prior[o1] - prior[o2];
                }
            });
        }

        if(ans[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(1,1);

        if(flag) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }



    }
}

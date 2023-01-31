package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_스페셜_저지 {
    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for (int i = 0; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        String[] str;
        for (int i = 0; i < N-1 ; i++) {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        str = br.readLine().split(" ");
        int[] priority = new int[N+1];
        Queue<Integer> ans = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(str[i]);
            ans.add(x);
            priority[x] = i;
        }

        for (int i = 0; i <= N; i++) {
            graph[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return priority[o1] - priority[o2];
                }
            });
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        if(ans.peek() != 1) {
            System.out.println(0);
            return;
        }

        ans.remove();

        while (!q.isEmpty()) {

            int node = q.remove();

            for (int i = 0; i < graph[node].size(); i++) {
                int adjv = graph[node].get(i);

                if(!ans.isEmpty() && adjv == ans.peek()) {
                    q.add(adjv);
                    ans.remove();
                }
            }
        }

        if(ans.isEmpty()) System.out.println(1);
        else System.out.println(0);


    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 이분_그래프 {

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            String[] str = br.readLine().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            List<Integer>[] graph = new ArrayList[V+1];

            int[] color = new int[V+1];

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                graph[a].add(b);
                graph[b].add(a);
            }

            Queue<Integer> q = new ArrayDeque<>();
            boolean flag = false;
            for (int i = 1; i <= V; i++) {
                if(color[i] == 0) {
                    q.add(i);

                    color[i] = 1;
                    while(!q.isEmpty()) {
                        int x = q.remove();

                        for (int j = 0; j < graph[x].size(); j++) {
                            int next = graph[x].get(j);

                            if(color[next] == color[x]) {
                                flag = true;
                                break;
                            }
                            else if(color[next] == 0){
                                color[next] = color[x] == 1 ? 2 : 1;
                                q.add(next);
                            }
                        }
                    }
                }
            }

            if(flag) {
                bw.write("NO\n");
            }
            else {
                bw.write("YES\n");
            }

        }
        bw.flush();
    }
}

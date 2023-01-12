package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 연결요소의_개수 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        boolean isVisited[] = new boolean[N+1];
        ArrayList<Integer> graph[] = new ArrayList[N+1];

        for(int i = 0 ; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++)
        {
            str= br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        int ans = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N;i++)
        {
            if(!isVisited[i])
            {
                q.add(i);
                ans++;
                while(!q.isEmpty())
                {
                    int pos = q.remove();

                    for(int j = 0 ; j < graph[pos].size(); j++)
                    {
                        int next = graph[pos].get(j);

                        if(!isVisited[next])
                        {
                            isVisited[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }
}

package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> graph[] = new ArrayList[N+1];
        boolean isvisited[] = new boolean[N+1];

        for(int i = 0 ; i < N+1;i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++)
        {
            String str[] = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        isvisited[1] = true;
        int count = 0;


        while(!q.isEmpty())
        {
            int pos = q.remove();

            for(int i = 0 ; i < graph[pos].size();i++)
            {
                int next = graph[pos].get(i);

                if(!isvisited[next])
                {
                    q.add(next);
                    isvisited[next]=true;
                    count++;
                }
            }
        }

        System.out.println(count);



    }
}

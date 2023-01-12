package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 점프_점프 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");

        ArrayList<Integer> graph[] = new ArrayList[N];

        for(int i = 0 ; i < N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N ; i++)
        {
            int x = Integer.parseInt(str[i]);

            if(i - x >= 0)
            {
                graph[i].add(i-x);
            }

            if(i+x < N)
            {
                graph[i].add(i+x);
            }

        }

        int start = Integer.parseInt(br.readLine()) -1;

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[N];

        q.add(start);
        visited[start] = true;
        int count = 1;

        while(!q.isEmpty())
        {
            int pos = q.remove();

            for(int i = 0 ; i < graph[pos].size();i++)
            {
                int next = graph[pos].get(i);

                if(!visited[next])
                {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }

            }
        }

        System.out.println(count);

    }
}

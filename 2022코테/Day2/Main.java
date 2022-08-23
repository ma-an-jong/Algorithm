package Day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static void rec(int index,int N){

        if(index == N)
        {
            for(int i = 0 ; i < N ; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < N ; i++)
        {
            arr[index] = i;
            rec(index+1,N);
        }


    }

    static void bfs(int start){
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        System.out.print(start+" ");
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty())
        {
            int pos = q.remove();

            for(int i = 0 ; i < graph[pos].size();i++)
            {
                int move = graph[pos].get(i);
                if(!visited[move])
                {
                    q.add(move);
                    System.out.print(move +" ");
                    visited[move] = true;
                }
            }
        }
        System.out.println();

    }

    static void dfs(int start,boolean visited[]){

        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 0 ; i < graph[start].size();i++)
        {
            int move = graph[start].get(i);

            if(!visited[move])
            {
                dfs(move,visited);
            }
        }
    }

   static int arr[] = new int[10];
    static ArrayList<Integer> graph[];

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        graph = new ArrayList[N+1];

        for(int i = 0 ; i <= N ; i ++)
        {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph[a].add(b);
            graph[b].add(a);
        }


        for(int i = 1 ; i <= N; i++)
        {
            boolean visited[] = new boolean[graph.length];
            dfs(i,visited);
            System.out.println();
        }

    }
}

package Day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 최소_스패닝_트리 {

    static int find(int[] arr, int a)
    {
        if(arr[a] == a)
        {
            return a;
        }

        int ap = find(arr,arr[a]);
        arr[a] = ap;
        return ap;
    }

    static void union(int[] arr, int a,int b)
    {
        int ap = find(arr,a);
        int bp = find(arr,b);
        if(ap != bp)
        {
            arr[ap] = bp;
        }

    }

    static class Edge implements Comparable<Edge>{
        int v;
        int adjv;
        int cost;

        Edge(int v,int adjv , int cost)
        {
            this.v = v;
            this.adjv = adjv;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        int arr[] = new int[V+1];

        for(int i =1;i<=V;i++)
        {
            arr[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();


        for(int i = 0 ; i < E;i++)
        {
            str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int adjv = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            pq.add(new Edge(v,adjv,cost));
        }

        int count = 0;
        int ans = 0;
        while(count < V-1)
        {
            Edge e = pq.remove();
            if(find(arr,e.v) != find(arr,e.adjv) )
            {
                union(arr,e.v,e.adjv);
                ans += e.cost;
                count++;
            }

        }

        System.out.println(ans);

    }
}

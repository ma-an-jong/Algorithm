package Algorithm.Trying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 레드_블루_스패닝_트리 {
    static class Edge
    {
        int v;
        int adjv;
        char color;

        Edge(int v,int adjv,char color)
        {
            this.v = v;
            this.adjv = adjv;
            this.color = color;
        }
    }

    static int find(int[] arr,int a)
    {
        if(arr[a] != a)
        {
            arr[a] = find(arr,arr[a]);
        }

        return arr[a];
    }

    static void union(int[] arr, int a, int b)
    {
        int ap = arr[a];
        int bp = arr[b];

        arr[bp] = ap;
    }

    static void init(int N)
    {
        cnt = 0;
        arr = new int[N];

        for(int i = 0 ; i < N;i++)
        {
            arr[i] = i;
        }
    }
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true)
        {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            if(n==0) break;
            PriorityQueue<Edge> blue = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {return o1.color - o2.color;}
            });
            PriorityQueue<Edge> red = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {return o2.color - o1.color;}
            });
            for(int i = 0 ; i < m;i++)
            {
                str = br.readLine().split(" ");
                char color = str[0].charAt(0);
                int v = Integer.parseInt(str[1]);
                int adjv = Integer.parseInt(str[2]);
                blue.add(new Edge(v,adjv,color));
                red.add(new Edge(v,adjv,color));
            }

            init(n+1);
            int max = 0;
            while(cnt < n-1)
            {
                Edge edge = blue.remove();
                if(find(arr,edge.v) != find(arr,edge.adjv))
                {
                    cnt++;
                    union(arr,edge.v,edge.adjv);
                    if(edge.color == 'B')
                    {
                        max++;
                    }
                }
            }

            init(n+1);
            int min = 0;
            while(cnt < n-1)
            {
                Edge edge = red.remove();
                if(find(arr,edge.v) != find(arr,edge.adjv))
                {
                    cnt++;
                    union(arr,edge.v,edge.adjv);
                    if(edge.color == 'B')
                    {
                        min++;
                    }
                }
            }

            if(k <= max && k >= min)
            {
                bw.write("1\n");
            }
            else
            {
                bw.write("0\n");
            }
        }
        bw.flush();


    }
}

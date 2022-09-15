package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _1로만들기2 {

    static class Pair implements Comparable<Pair>{
        int value;
        int index;

        Pair(int value,int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o)
        {
            return value - o.value;
        }
    }
    static int foo(int v)
    {
        if(v <= 1) return 0;

        if(dp[v] == 0)
        {
            int a = v%3==0?foo(v/3):Integer.MAX_VALUE;
            int b = v%2==0?foo(v/2):Integer.MAX_VALUE;
            int c = foo(v - 1);

            int ans = Math.min(Math.min(a,b),c);

            dp[v] = ans + 1;
        }

        return dp[v];
    }

    static void find(int v)
    {
        if(v <= 1) return;
        Pair a = v%3==0?new Pair(foo(v/3),v/3):new Pair(Integer.MAX_VALUE,0);
        Pair b = v%2==0?new Pair(foo(v/2),v/2):new Pair(Integer.MAX_VALUE,0);
        Pair c = new Pair(foo(v-1),v-1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(a); pq.add(b); pq.add(c);

        Pair ans = pq.remove();
        list.add(ans.index);
        find(ans.index);
    }


    static int[] dp = new int[5000000];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main (String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(foo(N)+"\n");
        list.add(N);
        find(N);
        for(int i = 0 ; i<list.size();i++){
            bw.write(list.get(i) + " ");
        }
        bw.flush();

    }

}


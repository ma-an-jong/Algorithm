package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ACM_Craft {
    static int foo(int W,int[] dp,int[] arr,ArrayList<Integer>[] graph)
    {
        if(dp[W] == Integer.MIN_VALUE)
        {
            int max = 0;
            for(int i = 0 ; i < graph[W].size();i++)
            {
                max = Math.max(max,foo(graph[W].get(i),dp,arr,graph));
            }
            dp[W] = max + arr[W];
        }
        return dp[W];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < testcase;t++)
        {
            String str[] = br.readLine().split(" ");
            int N  = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            int[] time = new int[N+1];
            str = br.readLine().split(" ");
            for(int i = 1 ; i <= N;i++)
            {
                time[i] = Integer.parseInt(str[i-1]);
            }
            int[] dp = new int[N+1];
            Arrays.fill(dp,Integer.MIN_VALUE);
            ArrayList<Integer>[] graph = new ArrayList[N+1];
            for(int i = 0 ; i <= N;i++) graph[i] = new ArrayList<Integer>();

            for(int i = 0 ; i < K;i++)
            {
                str = br.readLine().split(" ");
                int X = Integer.parseInt(str[0]);
                int Y = Integer.parseInt(str[1]);
                graph[Y].add(X);
            }
            int W = Integer.parseInt(br.readLine());
            int ans = foo(W,dp,time,graph);
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}

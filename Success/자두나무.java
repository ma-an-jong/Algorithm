package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 자두나무 {

    static int foo(int[][] dp,int w,int t){

        if(t > T) return 0;
        if(w > W) return 0;

        if(dp[w][t] != 0) return dp[w][t];

        int a = 0;
        int b = w % 2 + 1;
        if(b == arr[t]){
            a = 1;
        }

        dp[w][t] = Math.max(foo(dp,w,t+1),foo(dp,w+1,t+1)) + a;

        return dp[w][t];
    }

    static int T;
    static int W;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        T = Integer.parseInt(str[0]);
        W = Integer.parseInt(str[1]);

        arr = new int[T+1];

        for(int i = 1 ; i <= T;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[W+1][T+1];

        if(arr[0] == 1){
            dp[0][1] = 1;
        }

        System.out.println(Math.max(foo(dp,0,0),foo(dp,0,1)));



    }
}


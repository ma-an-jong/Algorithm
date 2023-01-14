package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 포도주_시식 {
    static int N;
    static int[] arr;

    static int foo(int[][] dp,int n, int m){
        if(n > N) return 0;
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        dp[n][m] = foo(dp,n+1,0);

        if(m == 2) {
            return dp[n][m];
        }

        dp[n][m] = Math.max(foo(dp,n+1,m+1) + arr[n],dp[n][m]);

        return dp[n][m];
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][3];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }

        System.out.println(foo(dp,1,0));
    }
}

package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 초콜릿_자르기 {
    static int foo(int[][] dp, int i, int j){
        if(i > N || i < 0 || j > M || j < 0) return INIT;

        if(dp[i][j] != INIT) return dp[i][j];

        for (int k = 1; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j],foo(dp,i,k) + foo(dp,i,j-k) +1);
        }

        for (int k = 1; k < i; k++) {
            dp[i][j] = Math.min(dp[i][j] , foo(dp,k,j) + foo(dp,i-k,j) +1);
        }

        return dp[i][j];
    }

    static int N;
    static int M;
    static int INIT = 301*301;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        int[][] dp = new int[N+1][M+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = INIT;
            }
        }
        dp[1][1] = 0;
        System.out.println(foo(dp,N,M));

    }
}

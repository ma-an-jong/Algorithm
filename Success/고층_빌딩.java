package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 고층_빌딩 {

    static long foo(long[][][] dp,int n,int l, int r){

        if( n < 0 || l < 0 || r < 0) return 0;

        if(dp[n][l][r] != 0) return dp[n][l][r];

        long a = foo(dp,n-1,l-1,r) % DIVISION;
        long b = foo(dp,n-1,l,r-1) % DIVISION;
        long c = (n-2)*foo(dp,n-1,l,r) % DIVISION;

        dp[n][l][r] = (a+b+c) % DIVISION;

        return dp[n][l][r];
    }


    static int DIVISION = 1_000_000_007;
    static int N;
    static int L;
    static int R;

    public static void main(String[] args) throws Exception {
        Stub.stub();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
        R = Integer.parseInt(str[2]);

        long[][][] dp = new long[N+1][L+1][R+1];

        dp[1][1][1] = 1;

        for(int n = 1 ; n < N;n++){
            for(int l = 1; l <= L;l++){
                for(int r = 1; r <= R; r++){
                    if(l < L){
                        dp[n+1][l+1][r] += dp[n][l][r];
                        dp[n+1][l+1][r] %= DIVISION;
                    }

                    if(r < R){
                        dp[n+1][l][r+1] += dp[n][l][r];
                        dp[n+1][l][r+1] %= DIVISION;
                    }

                    dp[n+1][l][r] += dp[n][l][r]*(n-1);
                    dp[n+1][l][r] %= DIVISION;
                }
            }
        }

        System.out.println(dp[N][L][R] % DIVISION);
    }
}

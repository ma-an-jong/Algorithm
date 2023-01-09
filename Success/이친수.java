package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수 {

    static long foo(long[] dp ,int i){
        if( i > N || i < 0) return 0;

        if(dp[i] != 0) return dp[i];

        for (int j = 1; j < i; j++) {
            dp[i] += (foo(dp,i-j)+ foo(dp,j));
        }

        return dp[i];
    }
    static int N;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[1] = 1;
        dp[0] = 0;

        System.out.println(foo(dp,N));
    }
}

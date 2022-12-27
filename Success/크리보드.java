package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 크리보드 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        for(int i = 0 ; i < n;i++){
            dp[i+1] = dp[i]+1;
        }

        for(int i = 0 ; i <= n;i++){
            for(int j = 3 ; j <= i;j++){
                dp[i] = Math.max(dp[i-j]*(j-1),dp[i]);
            }
        }

        System.out.println(dp[n]);


    }
}

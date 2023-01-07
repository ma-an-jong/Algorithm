package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 선물_전달 {
    static int DIVISION = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        if(N < 2) {
            System.out.println(0);
            return;
        }

        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            if(i % 2 == 0){
                dp[i] = dp[i-1]*i+1;
            }
            else {
                dp[i] = dp[i-1]*i -1;
            }

            dp[i] %= DIVISION;
        }

        //Arrays.stream(dp).forEach(v-> System.out.print(v+ " "));
        System.out.println(dp[N]);


    }
}

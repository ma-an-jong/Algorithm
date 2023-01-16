package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 타일_채우기 {
    static int N;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[31];
        int sum = 2;
        dp[2] = 3;
        for (int i = 4; i < 31; i+=2) {
            dp[i] = dp[i-2]*dp[2];
            dp[i] += sum;
            sum += dp[i-2]*2;
        }

        System.out.println(dp[N]);
    }
}

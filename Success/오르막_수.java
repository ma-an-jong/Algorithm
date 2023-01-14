package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막_수 {
    static int DIVISION = 10_007;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        Arrays.fill(dp[1],1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if(k>=j) {
                        dp[i+1][k] += dp[i][j];
                        dp[i+1][k] %= DIVISION;
                    }
                }
            }
        }

        int sum = Arrays.stream(dp[N]).sum();

        System.out.println(sum%DIVISION);

    }
}

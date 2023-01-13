package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _123더하기5 {
    static int DIVISION = 1_000_000_009;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[100_001][4];
        dp[1][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if(j == k) continue;
                    dp[i][j] += dp[i-j][k];
                    dp[i][j] %= DIVISION;
                }
            }
        }
        int testCaseSize = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 1; i <= 3; i++) {
                ans += dp[n][i];
                ans %= DIVISION;
            }
            bw.write(ans +"\n");
        }

        bw.flush();
    }
}

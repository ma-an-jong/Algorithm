package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 합분해 {

    static int N;
    static int K;
    static int DIVISION = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        int[][] dp = new int[201][201];
        dp[0][0] = 1;

        for (int i = 0; i < 201; i++) {
            for (int j = 1; j < 201; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] += dp[k][j-1];
                    dp[i][j] %= DIVISION;
                }
            }
        }

        System.out.println(dp[N][K]);



    }
}

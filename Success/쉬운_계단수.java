package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운_계단수 {
    static int N;
    static int DIVISION =  1_000_000_000;

    static int d[] = {-1,1};

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < 2; k++) {
                    int x = d[k] + j;
                    if (x >= 0 && x <= 9){
                        dp[i+1][x] += dp[i][j];
                        dp[i+1][x] %= DIVISION;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= DIVISION;
        }

        System.out.println(sum);

    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동물원 {
    static int N;
    static int DIVISION = 9901;
    public static void main(String[] args) throws Exception {

        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;


        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(j == 1 && k == 1) continue;
                    if(j == 2 && k == 2) continue;
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= DIVISION;
                }
            }
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % DIVISION);

    }
}

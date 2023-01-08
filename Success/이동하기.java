package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이동하기 {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            str = br.readLine().split(" ");
            for(int j = 1 ; j <= M;j++){
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        int[][] dp = new int[N+1][M+1];


        for(int i = 1 ; i <= N;i++){
            for(int j = 1 ; j <= M;j++){
                int a = Math.max(dp[i-1][j-1],dp[i-1][j]);
                dp[i][j] = Math.max(a,dp[i][j-1]) + arr[i][j];
            }
        }

        System.out.println(dp[N][M]);

    }
}

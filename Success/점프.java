package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 점프 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            String[] str = br.readLine().split(" ");

            for(int j = 0 ; j < n;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(arr[i][j] == 0) continue;
                if(j+arr[i][j] < n) dp[i][j+arr[i][j]] += dp[i][j];
                if(i+arr[i][j] < n) dp[i+arr[i][j]][j] += dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);

        br.close();
    }
}

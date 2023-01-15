package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연속합2 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[N][2];

        dp[0][1] = arr[0];
        dp[0][0] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + arr[i],arr[i]);
            dp[i][1] = Math.max(dp[i-1][1] + arr[i],dp[i-1][0]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans,dp[i][0]);
            ans = Math.max(ans,dp[i][1]);
        }

        System.out.println(ans);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 카드_구매하기 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str[i-1]);
        }

        int[] dp = new int[N+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i+j <= N) dp[i+j] = Math.max(arr[j] + dp[i],dp[i+j]);
            }
        }

        System.out.println(dp[N]);
    }
}

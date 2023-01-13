package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 제곱수의_합 {
    static int N;
    static int INIT = 100_001;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp,INIT);

        for (int i = 1; i*i <= N; i++) {
            dp[i*i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j*j <= N; j++) {
                int x = i + j*j;
                if(x <= N){
                    dp[x] = Math.min(dp[x],dp[i] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_구매하기_2 {
    static int INIT = 1001*100001;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str[i-1]);
        }

        int[] dp = new int[N+1];

        Arrays.fill(dp,INIT);

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i+j <= N){
                    if(dp[i] == INIT) dp[i+j] = arr[j];
                    else dp[i+j] = Math.min(dp[i+j],dp[i] + arr[j]);
                }
            }
        }

        System.out.println(dp[N]);

    }
}

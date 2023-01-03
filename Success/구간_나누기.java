package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간_나누기 {

    static int foo(int n,int m)
    {
        if(m == 0) return 0;
        if(n < 0) return INIT-1;

        if(dp[n][m] != INIT) return dp[n][m];

        dp[n][m] = foo(n-1,m);

        for(int i = n; i  >= 0; i--){
            dp[n][m] = Math.max(dp[n][m],foo(i-2,m-1) + sum[n] - sum[i] + arr[i]);
        }

        return dp[n][m];
    }

    static int[] sum;
    static int[][] dp;
    static int[] arr;

    static int INIT = -33000*101;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        arr = new int[N];
        sum = new int[N];

        for(int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = arr[0];
        for(int i = 1; i < N;i++){
            sum[i] = sum[i-1]+arr[i];
        }

        dp = new int[N][M+1];

        for(int i = 0 ;i < N;i++){
            Arrays.fill(dp[i],INIT);
        }

        System.out.println(foo(N-1,M));
    }
}

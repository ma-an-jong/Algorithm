package Algorithm.Trying;

import Algorithm.Stub;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1학년 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        long[][] dp = new long[n][21];

        dp[0][arr[0]] = 1;

        for(int i = 0 ; i < n-1;i++){

            for(int j = 0 ; j <= 20;j++){
                if(dp[i][j] != 0){
                    if(j+arr[i+1] <= 20) dp[i+1][j+arr[i+1]] += dp[i][j];
                    if(j - arr[i+1] >= 0) dp[i+1][j-arr[i+1]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }
}

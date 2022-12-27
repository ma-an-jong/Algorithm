package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전2 {
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];

        Arrays.fill(dp,100_001);
        dp[0] = 0;
        for(int j = 0 ; j <= k;j++){
            for(int i = 0 ; i < n;i++){
                if(j+arr[i] <= k){
                    dp[j + arr[i]] = Math.min(dp[j]+1,dp[j+arr[i]]);
                }
            }
        }

        if(dp[k]==100_001){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[k]);
        }

    }
}

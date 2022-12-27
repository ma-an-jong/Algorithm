package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전1 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int[] dp = new int[k+1];

        dp[0] = 1;

        for(int i = 0 ; i < arr.length;i++){
            for(int j = 0 ; j <= k ;j++){
                if(j - arr[i] >= 0){
                    dp[j] += dp[j-arr[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}

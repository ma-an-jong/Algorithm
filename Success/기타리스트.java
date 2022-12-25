package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 기타리스트 {
    static void foo(int[][] dp, int[] arr,int n,int P){
        if(n >= arr.length) return;

        if(dp[n][P] != -1){
            return;
        }

        dp[n][P] = 1;

        if(n+1 < arr.length){
            int a = P + arr[n+1];
            if(a >= 0 && a <= m){
                foo(dp,arr,n+1,a);
            }
        }

        if(n+1 < arr.length){
            int b = P - arr[n+1];
            if(b >= 0 && b <= m){
                foo(dp,arr,n+1,b);
            }
        }

    }
    static int s;
    static int m;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        m = Integer.parseInt(str[2]);

        str = br.readLine().split(" ");
        int[] arr = new int[n+1];

        for(int i = 0 ; i < n;i++){
            arr[i+1] = Integer.parseInt(str[i]);
        }


        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],-1);
        }

        int ans = -1;
        foo(dp,arr,0,s);

        for(int i =0; i <= m;i++){
            if(dp[n][i] == 1){
                ans = i;
            }
        }

        System.out.println(ans);
    }

}

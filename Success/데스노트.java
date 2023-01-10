package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 데스노트 {
    static int n;
    static int m;
    static int[] c;
    static long foo(long[][] dp , int i,int j) {

        if(i > n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        long padd = (long)(m-j+1)*(m-j+1);
        long ans = foo(dp,i+1,c[i]+1) + padd;

        if(j + c[i] <= m) {
            ans = Math.min(ans,foo(dp,i+1,j+c[i]+1));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        c = new int[n+1];
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }


        long[][] dp = new long[n+1][m+2];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m+1; j++) {
                dp[i][j] = -1;
            }
        }

        long ans =  foo(dp,2,c[1] + 1);

        System.out.println(ans);

    }
}

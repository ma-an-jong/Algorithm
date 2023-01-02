package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 방법을_출력하지_않는_숫자_맞추기 {

    static int foo(int[][] dp,int[] cur,int[] ans, int n, int l){

        if(n == N) return 0;

        if(dp[n][l] != 0) return dp[n][l];

        int c = (cur[n] + l) % 10;

        int left = (ans[n] - c + 10) % 10;
        int a = foo(dp,cur,ans,n+1,(l + left) % 10) + left;

        int right = (c - ans[n] + 10) % 10;
        int b = foo(dp,cur,ans,n+1,l) + right;

        dp[n][l] = Math.min(a,b);
        return dp[n][l];

    }
    static int N;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] cur = new int[N];
        int[] ans = new int[N];

        String str = br.readLine();

        for(int i = 0 ; i< N;i++){
            cur[i] = str.charAt(i) - '0';
        }

        str = br.readLine();
        for(int i = 0 ; i< N;i++){
            ans[i] = str.charAt(i) - '0';
        }

        int[][] dp = new int[N][10];

        System.out.println(foo(dp,cur,ans,0,0));



    }
}

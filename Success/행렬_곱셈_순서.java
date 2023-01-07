package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬_곱셈_순서 {

    static long foo(long[][] dp,int i,int j){
        if(i >= j) return 0;
        if(i >= N || j >= N || i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        for(int k = i ; k < j;k++){
            long a = foo(dp,i,k); long b = foo(dp,k+1,j);
            dp[i][j] = Math.min(dp[i][j],a+b+(long)arr[i][0]*arr[k][1]*arr[j][1]);
        }

        return dp[i][j];
    }

    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        System.out.println(foo(dp,0,N-1));

    }
}

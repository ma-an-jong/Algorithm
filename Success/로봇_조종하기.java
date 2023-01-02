package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇_조종하기 {

    static int max(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }

    static int foo(int[][][] dp, int[][] arr, int i,int j,int k){

        if(i >= N || i < 0 || j >= M || j < 0) return INIT;

        if(dp[i][j][k] != INIT) {
            return dp[i][j][k];
        }

        //0 위,  1 왼 , 2 오
        dp[i][j][0] = max(foo(dp,arr,i-1,j,0),foo(dp,arr,i-1,j,1),foo(dp,arr,i-1,j,2)) + arr[i][j];
        dp[i][j][1] = Math.max(foo(dp,arr,i,j-1,0),foo(dp,arr,i,j-1,1))+ arr[i][j];
        dp[i][j][2] = Math.max(foo(dp,arr,i,j+1,0),foo(dp,arr,i,j+1,2))+ arr[i][j];

        return max(dp[i][j][0],dp[i][j][1],dp[i][j][2]);
    }

    static int N;
    static int M;
    static int INIT = -1_000_000_000;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++){
                Arrays.fill(dp[i][j], INIT);
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        dp[0][0][0] = arr[0][0];
        dp[0][0][1] = arr[0][0];
        dp[0][0][2] = arr[0][0];

        for(int i = 0 ; i < N;i++){

            for(int j = 0 ; j < M ;j++){
                if(i != 0){
                    dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1],dp[i-1][j][2]) + arr[i][j];
                }

                if(j != 0){
                    dp[i][j][1] = Math.max(dp[i][j-1][0],dp[i][j-1][1]) + arr[i][j];
                }
            }

            for(int j = M-2; j >= 0; j--){
                dp[i][j][2] = Math.max(dp[i][j+1][0],dp[i][j+1][2]) + arr[i][j];
            }
        }

        System.out.println(max(dp[N-1][M-1][0],dp[N-1][M-1][1],dp[N-1][M-1][2]));

    }
}

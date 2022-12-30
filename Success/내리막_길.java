package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 내리막_길 {

    static int foo(int[][] dp,int[][] arr, int x,int y){

        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;

        for(int i= 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= n || nx < 0 || ny >= m || ny <0) continue;
            if(arr[ny][nx] <= arr[y][x]) continue;

            dp[y][x] += foo(dp,arr,nx,ny);
        }

        return dp[y][x];
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int m;
    static int n;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);

        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i = 0 ; i < m ; i++) {
            str = br.readLine().split(" ");

            for(int j = 0 ; j < n;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        dp[0][0] = 1;
        int ans = foo(dp,arr,n-1,m-1);

        System.out.println(ans);

    }
}

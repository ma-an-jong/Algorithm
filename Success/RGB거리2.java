package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGB거리2 {
    static int N;
    static int[][] arr;
    static int INIT = 1001*1001;
    static int foo(int[][][] dp ,int n,int rgb, int startRGB){

        if(n == N-1) {
            if(startRGB != rgb) {
                return arr[n][rgb];
            }

            return INIT;
        }

        if(dp[n][rgb][startRGB] != INIT) return dp[n][rgb][startRGB];

        int x = INIT;

        for (int i = 0; i < 3; i++) {
            if(rgb != i) x = Math.min(x,foo(dp,n+1,i,startRGB) + arr[n][rgb]);
        }
        dp[n][rgb][startRGB] = x;
        return x;
    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i <N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[][][] dp = new int[N][3][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j],INIT);
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(foo(dp,0,i,i),ans);
        }

        System.out.println(ans);

    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 벽_부수고_이동하기3_dfs {

    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static int[][][] dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MAX_VALUE;

    static boolean check(int y,int x){
        return y < 0 || x < 0 || y >= N || x >= M;
    }
    static void dfs(int y,int x,int k,boolean morning,int cnt) {

        if(y == N-1 && x == M-1) {
            ans =  Math.min(ans,cnt);
            return;
        }

        if(cnt > ans) return;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(check(ny,nx)) continue;

            if(arr[ny][nx] == 1) {

                if(k == K) continue;

                if(morning) {
                    if(dp[ny][nx][k+1] > cnt+1) {
                        dp[ny][nx][k+1] = cnt+1;
                        dfs(ny,nx,k+1,false,cnt+1);
                    }
                }
                else {
                    if(dp[ny][nx][k+1] > cnt+2) {
                        dp[ny][nx][k+1] = cnt+2;
                        dfs(ny,nx,k+1,false,cnt+2);
                    }
                }

            }
            else {
                if(dp[ny][nx][k] > cnt+1) {
                    dp[ny][nx][k] = cnt+1;
                    dfs(ny,nx,k,!morning,cnt+1);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        arr = new int[N][M];
        dp = new int[N][M][K+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        dp[0][0][0] = 1;
        dfs(0,0,0,true,1);

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }



    }
}

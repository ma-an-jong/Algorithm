package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 여행 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);

        int[][] dp = new int[M+1][N+1];
        int[][] arr = new int[N+1][N+1];
        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 0 ; i < N+1;i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if(a > b || arr[a][b] > c) continue;
            arr[a][b] = c;
            list[a].add(b);
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[j][i] = -1;
            }
        }

        dp[1][1] = 0;

        for(int i = 1; i < M ;i++){

            for(int j = 1 ; j <= N;j++){
                if(dp[i][j] == -1) continue;
                for(int k = 0 ; k < list[j].size();k++){
                    int next = list[j].get(k);
                    dp[i+1][next] = Math.max(dp[i+1][next],dp[i][j] + arr[j][next]);
                }
            }
        }

//        for (int i = 1; i <= M; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        int ans = 0;

        for(int i = 0 ; i <= M;i++){
            ans = Math.max(ans,dp[i][N]);
        }

        System.out.println(ans);
    }
}

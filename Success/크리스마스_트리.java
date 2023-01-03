package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 크리스마스_트리 {

    static long foo(long[][][][] dp , int r,int g,int b,int k){

        if(r < 0 || g < 0 || b < 0) return 0;
        if(k == 0) return 1;

        if(dp[r][g][b][k] != -1) return dp[r][g][b][k];

        dp[r][g][b][k] = 0;

        if(k % 3 == 0){
            int div = k/3;
            dp[r][g][b][k] += foo(dp,r-div,g-div,b-div,k-1)*comb[k][div]*comb[k-div][div];
        }

        if(k % 2 == 0){
            int div = k/2;
            dp[r][g][b][k] += foo(dp,r-div,g-div,b,k-1) * comb[k][div];
            dp[r][g][b][k] += foo(dp,r-div,g,b-div,k-1) * comb[k][div];
            dp[r][g][b][k] += foo(dp,r,g-div,b-div,k-1) * comb[k][div];
        }

        dp[r][g][b][k] += foo(dp,r-k,g,b,k-1);
        dp[r][g][b][k] += foo(dp,r,g-k,b,k-1);
        dp[r][g][b][k] += foo(dp,r,g,b-k,k-1);

        return dp[r][g][b][k];
    }

    static int N;
    static int R;
    static int G;
    static int B;
    static int[][] comb;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        R = Integer.parseInt(str[1]);
        G = Integer.parseInt(str[2]);
        B = Integer.parseInt(str[3]);
        comb = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }

        long[][][][] dp = new long[R+1][G+1][B+1][N+1];

        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= G; j++) {
                for (int k = 0; k <= B; k++) {
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }

        System.out.println(foo(dp,R,G,B,N));

    }
}

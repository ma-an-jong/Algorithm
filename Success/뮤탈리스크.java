package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 뮤탈리스크 {

    static int foo(int[][][] dp,int a,int b,int c){

        if(a == 0 && b == 0 && c == 0) return 0;

        if(dp[a][b][c] != 61){
            return dp[a][b][c];
        }

        for(int j = 0; j < 6;j++){
            int na = Math.max(0,a - d[j][0]);
            int nb = Math.max(0,b - d[j][1]);
            int nc = Math.max(0,c - d[j][2]);
            dp[a][b][c] = Math.min(foo(dp,na,nb,nc) + 1,dp[a][b][c]);
        }

        return dp[a][b][c];
    }
    static int[][] d = new int[][]{{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3}};
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] arr = new int[4];

        for(int i = 0; i < n ;i++){
            arr[i+1] = Integer.parseInt(str[i]);
        }

        int[][][] dp = new int[61][61][61];

        for(int i = 0 ; i < 61;i++){
            for(int j = 0 ; j<61;j++){
                Arrays.fill(dp[i][j],61);
            }
        }

        int ans = foo(dp,arr[1],arr[2],arr[3]);

        System.out.println(ans);
    }
}

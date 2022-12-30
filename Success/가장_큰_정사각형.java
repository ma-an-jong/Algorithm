package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 가장_큰_정사각형 {

    static int foo(int[][] dp,int[][] ans, int x,int y){

        if(x >= m || x < 0 || y >= n || y < 0) return 0;

        if(ans[y][x] == 0) return 0;

        if(dp[y][x] != 0){
            return dp[y][x];
        }

        int a = Math.min(
                Math.min(foo(dp,ans,x-1,y),foo(dp,ans,x,y-1))
                ,foo(dp,ans,x-1,y-1));

        dp[y][x] = a+1;

        return dp[y][x];
    }
    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0; i < n;i++){
            String line = br.readLine();
            for(int j = 0; j < m;j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < m;j++){
                if(arr[i][j] != 0){
                    ans = Math.max(foo(dp,arr,j,i),ans);
                }
            }
        }

        System.out.println(ans*ans);

    }
}

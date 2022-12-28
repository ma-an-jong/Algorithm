package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABC {

    static boolean valid(int i,int p){
        if(i <= n && p <= k) return true;

        return false;
    }

    static boolean foo(boolean[][][][] dp, int i,int a, int b,int p){

        if(!valid(i,p)) return false;

        if(i == n && p == k){
            StringBuilder sb = new StringBuilder();
            for(int index = 0 ; index < n;index++){
                sb.append(ans[index]);
            }
            System.out.println(sb.toString());
            return true;
        }

        if(dp[i][a][b][p]) return false;
        dp[i][a][b][p] = true;

        ans[i] = 'A';
        if(foo(dp,i+1,a+1,b,p)) return true;

        ans[i] = 'B';
        if(foo(dp,i+1,a,b+1,p+a)) return true;

        ans[i] = 'C';
        if(foo(dp,i+1,a,b,p+a+b)) return true;

        return false;
    }

    static int n;
    static int k;
    static char[] ans;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        ans = new char[n+1];

        boolean[][][][] dp = new boolean[n+1][n+1][n+1][k+1];

        if(foo(dp,0,0,0,0)) return;

        System.out.println(-1);
    }
}

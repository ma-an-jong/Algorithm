package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 즐거운_단어 {

    static long foo(long[][][][] dp,int n,int a,int b,int l){

        if(n == N) {
            if(l == 1){
                return 1;
            }

            return 0;
        }

        if(dp[n][a][b][l] != 0) return dp[n][a][b][l];

        long sum = 0;
        char c = str.charAt(n);

        if(c == '_') {

            for(int i = 1 ; i <= 2; i++){
                if(a == b && b == i) continue;
                sum += foo(dp,n+1,b,i,l)*(i == 1 ? 5 : 20);
            }

            if(a == b && b == 2){

            }
            else {
                sum += foo(dp,n+1,b,2,1);
            }
        }
        else {
            int next = set.contains(c) ? 1 : 2;
            if(a == b && b == next) return 0;
            return foo(dp,n+1,b,next, c == 'L' ? 1 : l);
        }

        dp[n][a][b][l] = sum;

        return dp[n][a][b][l];
    }

    static long[][][][] dp;
    static String str;
    static Set<Character> set = new HashSet<>(List.of('A','E','I','O','U'));
    static int N;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        N = str.length();
        dp = new long[N][3][3][2];

        System.out.println(foo(dp,0,0,0,0));


    }
}

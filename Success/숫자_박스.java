package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자_박스 {

    static int foo(int[][][] dp,int n,int upIndex,int botIndex){

        if(upIndex > n || botIndex > n) return INIT;
        if(upIndex == -1 || botIndex == -1 || n == -1) return 0;

        if(dp[n][upIndex][botIndex] != INIT){
            return dp[n][upIndex][botIndex];
        }

        int a = Math.max(foo(dp,n-1,upIndex-1,botIndex),foo(dp,n-1,upIndex,botIndex-1));
        a = Math.max(foo(dp,n-1,upIndex-1,botIndex-1) + top.get(upIndex)*bot.get(botIndex),a);

        dp[n][upIndex][botIndex] = a;

        return dp[n][upIndex][botIndex];
    }

    static int N;
    static List<Integer> top;
    static List<Integer> bot;
    static int[][][] dp;
    static int INIT = -101 * 401 * 401;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        top = new ArrayList<>();
        bot = new ArrayList<>();

        String[] str = br.readLine().split( " ");

        for(int i = 0 ; i < str.length;i++){
            int a = Integer.parseInt(str[i]);
            if(a != 0) top.add(a);
        }

        str = br.readLine().split( " ");

        for(int i = 0 ; i < str.length;i++){
            int a = Integer.parseInt(str[i]);
            if(a != 0) bot.add(a);
        }

        dp = new int[N][top.size()][bot.size()];
        for(int i = 0 ; i < N;i++){
            for(int j = 0 ; j < top.size();j++){
                Arrays.fill(dp[i][j],INIT);
            }
        }

        System.out.println(foo(dp,N-1,top.size()-1,bot.size()-1));
    }
}

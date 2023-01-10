package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 올바른_괄호_문자열 {

    static int N;
    static int DIVISION = 100_000;
    static char[] arr;
    static char[] x = new char[]{'(','[','{'};
    static char[] y = new char[]{')',']','}'};

    static long foo(long[][] dp, int i, int j){
        if(i > j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        long ans = 0;

        for (int k = i+1; k <= j; k++) {
            for (int l = 0; l < 3; l++) {
                if(arr[i] == x[l] || arr[i] == '?'){
                    if(arr[k] == y[l] || arr[k] == '?'){
                        ans += foo(dp,i+1,k-1)*foo(dp,k+1,j);
                        if(ans >= DIVISION){
                            ans %= DIVISION;
                            ans += DIVISION;
                        }
                    }
                }
            }
        }

        dp[i][j] = ans;

        return dp[i][j];
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        arr  = new char[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = line.charAt(i-1);
        }

        long[][] dp = new long[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }

        long ans = foo(dp,1,N);

        if(ans >= DIVISION) {
            System.out.printf("%05d\n",ans%DIVISION);
        }
        else {
            System.out.println(ans);
        }
    }
}

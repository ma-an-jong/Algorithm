package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 알약 {

    static long foo(long[][] dp,int f,int h){

        if(f < 0 || h < 0 || h >= dp.length) return 0;

        if(f==0 && h==0) return 1;

        if(dp[f][h] != 0){
            return dp[f][h];
        }

        dp[f][h] = foo(dp,f-1,h+1) + foo(dp,f,h-1);

        return dp[f][h];
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            long[][] dp = new long[n+1][n+1];

            long ans = foo(dp,n,0);

            bw.write(ans+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

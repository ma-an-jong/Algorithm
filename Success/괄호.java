package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 괄호 {

    static long foo(int l){

        if(l <= 0) return 1;
        if(l % 2 == 1) return 0;

        if(dp[l] != 0){
            return dp[l];
        }

        for(int i = 2; i <= l;i++)
        {
            dp[l] += (foo(i-2)*foo(l-i))%DIVISION;
            dp[l] %= DIVISION;
        }

        return dp[l];
    }

    static final int DIVISION = 1_000_000_007;
    static long[] dp = new long[5001];
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        dp[2] = 1;
        for(int t = 0 ; t < T ; t++){
            int l = Integer.parseInt(br.readLine());

            if(l % 2 == 1) {
                bw.write("0\n");
                continue;
            }

            bw.write(foo(l)+"\n");
        }

        bw.flush();
        bw.close();
    }
}

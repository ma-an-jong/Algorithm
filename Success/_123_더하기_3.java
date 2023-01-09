package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _123_더하기_3 {
    static int DIVISION = 1_000_000_009;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            dp[i] %= DIVISION;
        }

        for(int test = 0 ; test < testCase;test++)
        {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }
        bw.flush();
    }
}

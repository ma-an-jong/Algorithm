package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _123더하기7 {
    static int DIVISION = 1_000_000_009;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for(int i = 1 ; i <= 1000;i++){
            for(int j = 1; j <= 1000 ;j++){
                for(int k = 1; k<=3;k++){
                    if(i-k >= 0){
                        dp[i][j] += dp[i-k][j-1];
                        dp[i][j] %= DIVISION;
                    }
                }
            }
        }

        for(int t = 0; t < T;t++){
            String[] str = br.readLine().split(" ");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            bw.write((dp[n][m] % DIVISION )+"\n");
            bw.flush();
        }

    }
}

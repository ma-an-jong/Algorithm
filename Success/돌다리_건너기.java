package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 돌다리_건너기 {

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int patternLength = line.length() + 1;

        char[] pattern = new char[patternLength+1];

        for(int i = 1 ; i < patternLength;i++){
            pattern[i] = line.charAt(i-1);
        }
        line = br.readLine();
        int N = line.length();

        char[][] bridge = new char[N+2][2];

        for(int i = 1 ; i <= N;i++){
            bridge[i][0] = line.charAt(i-1);
        }

        line = br.readLine();

        for(int i = 1 ; i <= N;i++){
            bridge[i][1] = line.charAt(i-1);
        }

        int[][][] dp = new int[N+2][patternLength+1][2];

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int i = 0; i <= N;i++){
            for(int j = 0 ; j < patternLength;j++){
                for(int k = 0 ; k < 2;k++){
                    for(int w = i+1;w <= N+1;w++){
                        if(bridge[w][(k+1)%2] == pattern[j+1]) {
                            dp[w][j+1][(k+1)%2] += dp[i][j][k];
                        }
                    }
                }
            }
        }



        System.out.println(dp[N+1][patternLength][0] + dp[N+1][patternLength][1]);

    }
}

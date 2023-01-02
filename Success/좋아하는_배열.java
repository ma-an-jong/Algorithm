package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋아하는_배열 {

    static int DIVISION = 1_000_000_007;
    static int N;
    static int K;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

         N = Integer.parseInt(str[0]);
         K = Integer.parseInt(str[1]);
        int[][] dp = new int[N+1][K+1];
        list = new ArrayList[K+1];
        int[] sum = new int[N+1];

        for(int i = 1; i <= K;i++){
            list[i] = new ArrayList<>();
            for(int j = i*2; j <= K;j += i){
                list[i].add(j);
            }

        }

        Arrays.fill(dp[1],1);

        sum[1] = K;
        for(int i = 2; i <= N;i++){
            for(int j = 1; j <= K;j++) {
                dp[i][j] = sum[i-1];
                for (Integer num : list[j]){
                    dp[i][j] -= dp[i - 1][num];
                    dp[i][j] %= DIVISION;
                    dp[i][j] += DIVISION;
                    dp[i][j] %= DIVISION;
                }
                sum[i] += dp[i][j];
                sum[i] %= DIVISION;
            }
        }

        System.out.println(sum[N]);

    }
}

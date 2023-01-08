package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Acka {
    static int DIVISION = 1_000_000_007;
    static int S;
    static int A;
    static int B;
    static int C;

    static int[] da = {1,0,0,1,0,1,1};
    static int[] db = {0,1,0,1,1,0,1};
    static int[] dc = {0,0,1,0,1,1,1};

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        S = Integer.parseInt(str[0]);
        A = Integer.parseInt(str[1]);
        B = Integer.parseInt(str[2]);
        C = Integer.parseInt(str[3]);

        int[][][][] dp = new int[S+1][A+1][B+1][C+1];

        dp[0][0][0][0] = 1;

        for(int s = 0 ; s < S;s++){
            for (int a = 0; a <= A; a++) {
                for (int b = 0; b<= B; b++) {
                    for (int c = 0; c <= C; c++) {
                        for (int i = 0; i < 7; i++) {
                            int na = a+da[i];
                            int nb = b + db[i];
                            int nc = c + dc[i];
                            try{
                                dp[s+1][na][nb][nc] += dp[s][a][b][c];
                                dp[s+1][na][nb][nc] %= DIVISION;
                            }
                            catch (Exception e){

                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[S][A][B][C]);


    }
}

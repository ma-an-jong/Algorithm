package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 미로에_갇힌_상근 {

    static int[] dx = {0,1,1,0,-1,-1};
    static int[] dy = {1,0,-1,-1,0,1};
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][][] dp = new int[14+1][14*2 + 1][14*2 + 1];

        dp[0][14][14] = 1;

        for(int i = 1 ; i <= 14;i++) {

            for(int x = 0 ; x < 29;x++){
                for(int y = 0 ; y < 29;y++){
                    for(int w = 0;w<6;w++) {
                        int nx = x + dx[w];
                        int ny = y + dy[w];

                        if(nx >= 0 && nx < 29 && ny >= 0 && ny < 29){
                            dp[i][x][y] += dp[i-1][nx][ny];
                        }
                    }
                }
            }

        }



        for(int t = 0; t< T ;t++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n][14][14]+"\n");
        }
        bw.flush();

    }
}

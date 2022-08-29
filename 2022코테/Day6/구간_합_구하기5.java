package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구간_합_구하기5 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int map[][] = new int[N+1][N+1];
        int sum[][] = new int[N+1][N+1];

        for(int i = 1 ; i <=N;i++)
        {
            str = br.readLine().split(" ");
            for(int j = 1; j <= N;j++)
            {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        for(int i = 1 ; i <=N;i++)
        {
            for(int j = 1; j <= N;j++)
            {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
            }
        }



        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);

            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);

            int ans = sum[x2][y2] - sum[x2][y1-1] -sum[x1-1][y2] + sum[x1-1][y1-1];

            bw.write(ans+"\n");
        }
        bw.flush();

    }
}

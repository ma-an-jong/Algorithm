package Day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 회장뽑기 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String str[];

        int arr[][] = new int[N+1][N+1];

        for(int i = 0 ; i <= N;i++)
        {
            Arrays.fill(arr[i],10000);
        }

        while(true)
        {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if(a == -1 && b == -1) break;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i = 1; i <= N;i++)
        {
            arr[i][i] = 0;
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N;j++)
            {
                if(i == j) continue;
                for (int k = 1;  k <= N;k++)
                {
                    if( k == i || k== j) continue;

                    arr[j][k] = Math.min(arr[j][i] + arr[i][k],arr[j][k]);
                }
            }
        }



        int ans[] = new int[N+1];
        for(int i = 1;i <=N;i++)
        {
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= N;j++)
            {
                if(i == j) continue;
                max = Math.max(arr[i][j] , max);
            }
            ans[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N ;i++)
        {
            min = Math.min(min,ans[i]);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i= 1; i <=N ; i++)
        {
            if(ans[i] == min) {
                sb.append(i+" ");
                count++;
            }
        }

        bw.write(min + " " + count + "\n");
        bw.write(sb.toString());


        bw.flush();
    }
}


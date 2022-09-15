package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 펠린드롬 {
    
    // 1 == 팰린드롬 , 0 == 초기화, 2 == 아님
    static int dp(int arr[],int S,int E)
    {
        if(S > E) return 1;

        if(memo[S][E] == 0)
        {
            int result = dp(arr,S+1,E-1);
            if(result == 1)
            {
                if(arr[S] == arr[E])
                {
                    memo[S][E] = 1;
                }
                else
                {
                    memo[S][E] = 2;
                }
            }
            else
            {
                memo[S][E] = 2;
            }
        }

        return memo[S][E];
    }
    static int[][] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[str.length+1];
        for(int i = 0 ; i < str.length;i++) arr[i+1] = Integer.parseInt(str[i]);
        int M = Integer.parseInt(br.readLine());
        memo = new int[N+1][N+1];
        for(int i = 0; i <= N;i++ )
        {
            memo[i][i] = 1;
        }

        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");
            int S = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            int ans = dp(arr,S,E);
            if(ans == 1)
            {
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }

        }

        bw.flush();
    }
}

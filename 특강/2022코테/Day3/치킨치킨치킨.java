package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 치킨치킨치킨 {
    public static void comb(int n,int idx,int cnt)
    {
        if(cnt > 3) return;
        if(idx == n)
        {
            if(cnt == 3)
            {
                int list[] = new int[3];
                int cursor = 0;
                for(int i = 0 ; i < n;i++)
                {
                    if(select[i] == 1)
                    {
                        list[cursor++] = i;
                    }
                }
                int ans[] = new int[N];
                for(int j = 0 ; j < N;j++)
                {
                    for(int i = 0 ; i < list.length;i++)
                    {
                        ans[j] = Math.max(map[j][list[i]],ans[j]);
                    }
                }
                int sum = 0 ;
                for(int a : ans)
                    sum += a;

                max = Math.max(sum,max);
            }
            return;
        }

        select[idx] = 0;
        comb(n,idx+1,cnt);
        select[idx] = 1;
        comb(n,idx+1,cnt+1);

    }

    static int N;
    static int max = Integer.MIN_VALUE;
    static int map[][];
    static int select[];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        map = new int[N][M];
        select = new int[M];

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");

            for(int j = 0 ; j < M;j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        comb(M,0,0);

        System.out.println(max);

    }
}

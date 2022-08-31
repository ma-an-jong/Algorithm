package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미친_로봇 {
    static class Position{
        int x;
        int y;
        int count = 0;

        Position(int x,int y)
        {
            this.x=x;
            this.y=y;
        }

    }

    static void dfs(int N,Position pos,int cnt,double percent)
    {
        if(cnt == N)
        {
            ans += percent;
            return ;
        }

        for(int i = 0 ; i < 4;i++)
        {
            int x = pos.x + dx[i];
            int y = pos.y + dy[i];

            try
            {
                if(!visited[y][x])
                {
                    visited[y][x] = true;
                    dfs(N,new Position(x,y),cnt+1,percent*d[i]);
                    visited[y][x] = false;
                }
            }
            catch (Exception e)
            {
                continue;
            }
        }
    }
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static double d[];
    static double ans = 0;
    static boolean visited[][] = new boolean[30][30];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);


        d = new double[4];
        for(int i = 1; i <= 4; i++)
        {
            d[i-1] = Double.parseDouble(str[i])/100;
        }

        visited[15][15] = true;
        dfs(N,new Position(15,15),0,1);
        System.out.println(ans);



    }
}

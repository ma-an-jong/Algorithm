package Day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 연구소 {

    static class Pair{
        int x;
        int y;

        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static void solve(Pair a,Pair b, Pair c)
    {
        if(map[a.y][a.x] != 0 && map[b.y][b.x] != 0 &&  map[c.y][c.x] != 0) return;

        int copy[][] = new int[N][M];

        for(int i = 0 ; i < N;i++)
        {
            for(int j = 0 ; j < M; j++)
            {
                copy[i][j] = map[i][j];
            }
        }

        copy[a.y][a.x] = 1;
        copy[b.y][b.x] = 1;
        copy[c.y][c.x] = 1;

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0 ; i < N;i++)
        {
            for(int j = 0 ; j < M;j++)
            {
                if(copy[i][j] == 2)
                {
                    q.add(new Pair(j,i));

                    while(!q.isEmpty())
                    {
                        Pair pos = q.remove();

                        for(int k = 0 ; k < 4;k++)
                        {
                            int x = pos.x + dx[k];
                            int y = pos.y + dy[k];

                            try{
                                if(copy[y][x] == 0)
                                {
                                    copy[y][x] = 2;
                                    q.add(new Pair(x,y));
                                }
                            }
                            catch (Exception e)
                            {
                                continue;
                            }
                        }

                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0 ; i < N;i++)
        {
            for(int j = 0; j < M;j++)
            {
                if(copy[i][j] == 0)
                {
                    sum ++;
                }
            }
        }

        ans = Math.max(ans,sum);
    }

    static void comb(Pair arr[] ,int N, int R,int idx,int count)
    {
        if(count > R) return;

        if(N == idx)
        {
            if(R == count)
            {
                ArrayList<Pair> list = new ArrayList<>();
                for(int i = 0 ; i < select.length;i++)
                {
                    if(select[i] == 1)
                    {
                        list.add(arr[i]);
                    }
                }

                solve(list.get(0),list.get(1),list.get(2));
            }
            return;
        }


        select[idx] = 0;
        comb(arr,N,R,idx+1,count);
        select[idx] = 1;
        comb(arr,N,R,idx+1,count+1);

    }
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int select[];

    static int ans = 0;
    static int N;
    static int M;
    static int map[][];

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

         N = Integer.parseInt(str[0]);
         M = Integer.parseInt(str[1]);

        map = new int[N][M];


        int cursor = 0;

        for(int i = 0 ; i < N ; i++)
        {
            str  = br.readLine().split(" ");

            for(int j = 0 ; j < M;j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 0) cursor++;
            }
        }

        Pair arr[] = new Pair[cursor];
        select = new int[cursor];

        cursor = 0;

        for(int i = 0 ; i < N;i++)
        {
            for(int j = 0 ; j < M;j++)
            {
                if(map[i][j] ==0)
                {
                    arr[cursor++] = new Pair(j,i);
                }
            }
        }

        comb(arr,cursor,3,0,0);

        System.out.println(ans);
    }
}

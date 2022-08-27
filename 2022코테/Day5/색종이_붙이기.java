package Day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 색종이_붙이기 {
    static boolean validation(int j,int i,int windowSize)
    {

        if(i + windowSize > 10 || j + windowSize > 10) return false;

            for(int y = i ; y < i+windowSize;y++)
            {
                for(int x = j; x < j+windowSize;x++)
                {
                    if(map[y][x] == 0)
                    {
                        return false;
                    }
                }
            }

        return true;
    }

    static void masking(int j,int i,int windowSize)
    {
        for(int y = i ; y < i+windowSize;y++)
        {
            for(int x = j; x < j+windowSize;x++)
            {
                map[y][x] = 0;
            }
        }
    }

    static void unmasking(int j,int i,int windowSize)
    {
        for(int y = i ; y < i+windowSize;y++)
        {
            for(int x = j; x < j+windowSize;x++)
            {
                map[y][x] = 1;
            }
        }
    }

    static void foo(int x,int y,int cnt)
    {

        if(x == 10 && y == 9)
        {
            ans = Math.min(ans,cnt);
            return;
        }

        if(ans <= cnt) return;

        if(x == 10) {
            foo(0,y+1,cnt);
            return;
        }

        if(map[y][x] == 1)
        {
            int windowSize = 5;

            while(windowSize > 0)
            {
                if(validation(x,y,windowSize) && count[windowSize] > 0)
                {
                    masking(x,y,windowSize);
                    count[windowSize]--;
                    foo(x+1,y,cnt+1);
                    unmasking(x,y,windowSize);
                    count[windowSize]++;
                }

                windowSize--;
            }

        }
        else
        {
            foo(x+1,y,cnt);
        }

    }

    static int ans = Integer.MAX_VALUE;
    static int N = 10;
    static int map[][] = new int[N][N];
    static boolean visited[][] = new boolean[10][10];
    static int count[] = {0,5,5,5,5,5};


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0 ;i<N;i++)
        {
            String str[] = br.readLine().split(" ");
            for(int j = 0;j < N;j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        foo(0,0,0);

        if(ans == Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }

    }
}

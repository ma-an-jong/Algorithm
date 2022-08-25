package Day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 숫자판_점프 {

    static class Pair{
        int x;
        int y;

        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }

    }

    static void comb(int N,int idx,Pair p,String s)
    {
        if(N == idx)
        {
            if(!set.contains(s))
            {
                set.add(s);
                count++;
            }
            return;
        }

        for(int i = 0 ; i < 4 ; i++)
        {
            int x = p.x + dx[i];
            int y = p.y + dy[i];

            try
            {
                char c = map[y][x];
                comb(N,idx+1,new Pair(x,y),s+c);
            }
            catch (Exception e)
            {
                continue;
            }
        }
    }
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static char map[][];
    static int count = 0;
    static Set<String> set = new HashSet<String>();

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map= new char[5][5];

        for(int i = 0; i < 5; i ++)
        {
            String str[] = br.readLine().split(" ");
            for(int j = 0 ; j <5 ;j++)
            {
                map[i][j] = str[j].charAt(0);
            }
        }

        for(int i= 0 ; i < 5;i++)
        {
            for(int j = 0 ; j < 5;j++)
            {
                Pair p = new Pair(j,i);
                comb(5,0,p,"" + map[p.y][p.x]);
            }
        }

        System.out.println(count);
    }
}

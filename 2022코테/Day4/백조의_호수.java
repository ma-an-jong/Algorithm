package Day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 백조의_호수 {
    static class Pair{
        int x;
        int y;

        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        char map[][] = new char[N][M];
        int visited[][] = new int[N][M];

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};

        ArrayList<Pair> list = new ArrayList<>();
        Queue<Pair> water = new LinkedList<>();
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0 ; i < N;i++)
        {
            String s = br.readLine();
            for(int j = 0 ; j < M; j++)
            {
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'L')
                {
                    list.add(new Pair(j,i));
                }

                if(map[i][j] != 'X')
                {
                    water.add(new Pair(j,i));
                }
            }
        }

        Pair L1 = list.get(0);
        Pair L2 = list.get(1);

        q.add(L1);
        visited[L1.y][L1.x] = 1;
        int day = 0;

        while(true)
        {
            Queue<Pair> replace = new LinkedList<>();

            while(!q.isEmpty())
            {
                Pair p = q.remove();

                if((p.x == L2.x) && (p.y == L2.y))
                {
                    System.out.println(day);
                    return;
                }

                for(int i = 0 ;i < 4;i++)
                {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    try
                    {
                        if(visited[y][x] == 0)
                        {
                            visited[y][x] = 1;

                            if (map[y][x] == 'X')
                            {
                                replace.add(new Pair(x, y));
                            }
                            else
                            {
                                q.add(new Pair(x,y));
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }
            }

            Queue<Pair> tmp = new LinkedList<>();

            while(!water.isEmpty())
            {
                Pair p = water.remove();

                for(int i = 0; i < 4;i++)
                {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

                    try
                    {
                        if(map[y][x] == 'X')
                        {
                            map[y][x] = '.';
                            tmp.add(new Pair(x,y));
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }
            }

            q = replace;
            water = tmp;
            day++;

        }


    }
}

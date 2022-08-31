package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.LinkedList;
import java.util.Queue;

public class 치즈 {
    static class Pair{
        int x;
        int y;

        Pair(int x,int y)
        {
            this.x= x;
            this.y= y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int map[][] = new int[N][M];

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");

            for(int j = 0; j < M;j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1)
                {
                    queue.add(new Pair(j,i));
                }
            }
        }
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};
        Queue<Pair> q = new LinkedList<>();
        map[0][0] = 2;

        q.add(new Pair(0,0));
        while(!q.isEmpty())
        {
            Pair p = q.remove();

            for(int i = 0 ; i < 4;i++)
            {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                try
                {
                    if(map[y][x] == 0)
                    {
                        map[y][x]=2;
                        q.add(new Pair(x,y));
                    }
                }
                catch (Exception e)
                {
                    continue;
                }
            }
        }

        int count = 0;

        while (true)
        {
            if(queue.isEmpty())
            {
                System.out.println(count);
                return;
            }
            int size = queue.size();
            Queue<Pair> tmp = new LinkedList<>();
            Queue<Pair> remove = new LinkedList<>();

            for(int i = 0 ; i < size;i++)
            {
                Pair p = queue.remove();
                int cnt = 0;

                for(int j = 0; j < 4;j++)
                {
                    int x = p.x + dx[j];
                    int y = p.y + dy[j];

                    try
                    {
                        if(map[y][x] == 2)
                        {
                            cnt++;
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }

                if(cnt >= 2)
                {
                    remove.add(new Pair(p.x,p.y));
                }
                else
                {
                    tmp.add(new Pair(p.x,p.y));
                }

            }

            while(!tmp.isEmpty())
            {
                Pair pair = tmp.remove();
                queue.add(new Pair(pair.x,pair.y));
            }

            while(!remove.isEmpty())
            {
                Pair pair = remove.remove();

                for(int i = 0; i < 4; i++)
                {
                    int x = pair.x + dx[i];
                    int y = pair.y + dy[i];

                    try
                    {
                        if(map[y][x] == 2)
                        {
                            map[pair.y][pair.x] = 2;
                        }
                        else if(map[y][x] == 0)
                        {
                            remove.add(new Pair(x,y));
                        }
                    }
                    catch (Exception e)
                    {

                    }
                }

            }

            count++;
        }
    }
}

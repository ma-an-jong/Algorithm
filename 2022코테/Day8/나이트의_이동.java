package Day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 나이트의_이동 {
    static class Pair{
        int x;
        int y;
        int count = 0;

        Pair(int x,int y)
        {
            this.x = x;
            this.y  =y;
        }

        Pair(int x,int y,int count)
        {
            this.x = x;
            this.y  =y;
            this.count = count;
        }

    }

    static int dx[] = {2 , 1,-1,-2,-2,-1,1,2};
    static int dy[] = {-1,-2,-2,-1, 1, 2,2,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase= Integer.parseInt(br.readLine());

        for(int t= 0; t< testcase;t++)
        {
            int I = Integer.parseInt(br.readLine());

            boolean visited[][] =new boolean[I][I];

            String str[] = br.readLine().split(" ");
            Pair start = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            str = br.readLine().split(" ");
            Pair end = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]));

            PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.count - o2.count;
                }
            });

            q.add(new Pair(start.x,start.y,0));
            visited[start.y][start.x] = true;
            while(!q.isEmpty())
            {
                Pair pair = q.remove();

                if(pair.x == end.x && pair.y == end.y)
                {
                    bw.write(pair.count+"\n");
                    break;
                }

                for(int i = 0 ; i < 8 ; i++)
                {
                    int x = pair.x + dx[i];
                    int y = pair.y + dy[i];

                    try
                    {
                        if(!visited[y][x])
                        {
                            visited[y][x] = true;
                            q.add(new Pair(x,y,pair.count + 1));
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }
            }

        }
        bw.flush();
    }
}

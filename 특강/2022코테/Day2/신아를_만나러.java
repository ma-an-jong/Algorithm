package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 신아를_만나러 {



    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");

        int X = Integer.parseInt(str[1]) + 500;
        int Y = Integer.parseInt(str[0]) + 500;
        int N = Integer.parseInt(str[2]);

        int map[][] = new int[1000+1][1000+1];
        map[Y][X] = 1;

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");

            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[0]);

            map[y+500][x+500] = -1;
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qv = new LinkedList<>();

        qx.add(500);
        qy.add(500);
        qv.add(0);

        map[500][500] = -1;

        while(!qx.isEmpty())
        {
            int x = qx.remove();
            int y = qy.remove();
            int v = qv.remove();

            for(int i = 0 ; i < 4;i++)
            {
                int mx = x + dx[i];
                int my = y + dy[i];

                try
                {
                    if(map[my][mx] == 0)
                    {
                        map[my][mx] = -1;
                        qy.add(my);
                        qx.add(mx);
                        qv.add(v+1);
                    }
                    else if(map[my][mx] == 1)
                    {
                        System.out.println(v+1);
                        return;
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

package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농_배추 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t< testcase; t++)
        {
            String str[] = br.readLine().split(" ");

            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            int K = Integer.parseInt(str[2]);
            int map[][] = new int[N][M];

            for(int i = 0 ; i < K ;i++)
            {
                str = br.readLine().split(" ");

                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                map[y][x] = 1;
            }

            int count = 0;
            Queue<Integer> qx = new LinkedList<>();
            Queue<Integer> qy = new LinkedList<>();

            int dx[] = {1,0,-1,0};
            int dy[] = {0,1,0,-1};

            for(int i = 0 ; i < N;i++)
            {
                for(int j = 0 ; j < M;j++)
                {
                    if(map[i][j] == 1)
                    {
                        qx.add(j);
                        qy.add(i);
                        count++;
                    }

                    while(!qx.isEmpty())
                    {
                        int x = qx.remove();
                        int y = qy.remove();

                        for(int k = 0; k < 4;k++)
                        {
                            int mx = x+dx[k];
                            int my = y+dy[k];

                            try
                            {
                                if(map[my][mx] == 1)
                                {
                                    qx.add(mx);
                                    qy.add(my);
                                    map[my][mx] =0;
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

            System.out.println(count);


        }

    }
}

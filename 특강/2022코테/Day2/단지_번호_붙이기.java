package Day2;

import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지_번호_붙이기 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char map[][] = new char[N][N];



        for(int i = 0; i < N ; i++)
        {
            String str = br.readLine();

            for(int j = 0 ; j < N ; j++)
            {
                map[i][j] = str.charAt(j);
            }
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};



        int ans = 0;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++)
        {
            for(int j = 0 ; j < N; j++)
            {

                if(map[i][j] == '1')
                {
                    qy.add(i);
                    qx.add(j);
                    map[i][j] = '0';
                    count++;
                    ans++;

                    while(!qx.isEmpty())
                    {
                        int x = qx.remove();
                        int y = qy.remove();

                        for(int k = 0 ; k < 4; k++)
                        {
                            int mx = x + dx[k];
                            int my = y + dy[k];

                            try
                            {
                                if(map[my][mx] == '1')
                                {
                                    qx.add(mx);
                                    qy.add(my);
                                    map[my][mx] = '0';
                                    count++;
                                }
                            }
                            catch (Exception e)
                            {
                                continue;
                            }

                        }
                    }

                    list.add(count);
                    count = 0;
                }


            }
        }
        bw.write(ans+"\n");
        Collections.sort(list);
        for(int i = 0 ; i < list.size();i++)
        {
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
    }
}

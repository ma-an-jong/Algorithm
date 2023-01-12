package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 꽃길 {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];

        for(int i = 0;i < N;i++)
        {
            String str[] = br.readLine().split(" ");
            for(int j = 0 ; j < N;j++)
            {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }




        int dx[] = {0,1,0,-1,0};
        int dy[] = {0,0,1,0,-1};

        ArrayList<Pair> list = new ArrayList<>();

        for(int i = 1; i < N-1;i++)
        {
            for(int j = 1; j < N-1; j++)
            {
                list.add(new Pair(j,i));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < list.size();i++)
        {
            for(int j = i+1;j < list.size();j++)
            {
                for(int k = j+1; k < list.size() ; k++)
                {
                    Pair p[] = new Pair[3];

                    p[0] = list.get(i);
                    p[1] = list.get(j);
                    p[2] = list.get(k);

                    boolean visited[][] = new boolean[N][N];
                    ArrayList<Integer> ans = new ArrayList<>();

                    for(int s = 0 ; s < 3;s++)
                    {
                        Pair pair = p[s];

                        for(int w = 0; w < 5; w++)
                        {
                            int x = pair.x + dx[w];
                            int y = pair.y + dy[w];

                            if(!visited[y][x])
                            {
                                visited[y][x] = true;
                                ans.add(map[y][x]);
                            }
                        }
                    }

                    int sum = 0;
                    if(ans.size() == 15)
                    {
                        for(int a : ans)
                        {
                            sum+= a;
                        }
                        min = min > sum ? sum : min;
                    }

                }
            }
        }

        System.out.println(min);

    }
}

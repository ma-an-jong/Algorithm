package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자_정사각형 {

    static int toint(char c)
    {
        return c - '0';
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        char map[][] = new char[N][M];

        for(int i = 0 ; i < N;i++)
        {
            String s =br.readLine();
            for(int j = 0 ; j < s.length();j++)
            {
                map[i][j] = s.charAt(j);
            }
        }

        int dx[] = {0,1,0,1};
        int dy[] = {0,0,1,1};

        int LENGTH = N > M ? N : M;

        int len = 1;

        for(int i = 1; i < LENGTH;i++)
        {
            for(int y = 0;y < N;y++)
            {
                for(int x = 0 ; x < M;x++)
                {
                    int ans[] = new int[4];
                    try
                    {
                        for(int k = 0; k < 4; k++)
                        {
                            int mx = x + dx[k]*i;
                            int my = y + dy[k]*i;

                            ans[k] = toint(map[my][mx]);

                        }
                    }
                    catch (Exception e)
                    {
                        break;
                    }
                    boolean flag = true;

                    for(int k = 0 ; k < 3; k++)
                    {
                        if(ans[k] != ans[k+1])
                        {
                            flag = false;
                        }
                    }

                    if(flag)
                    {
                        len = i+1;
                    }
                }
            }
        }

        System.out.println((len)*(len));




    }
}

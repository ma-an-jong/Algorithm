package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 스도쿠 {

    static void foo(int x,int y) throws Exception{

        if(y == 9)
        {
            for(int i = 0 ; i < 9;i++)
            {
                for(int j = 0 ; j < 9;j++)
                {
                    bw.write(arr[i][j]+"");
                }
                bw.write("\n");
            }

            throw new Exception();
        }

        if(arr[y][x] != 0 )
        {
            if(x == 8)
            {
                foo(0,y+1);
            }
            else
            {
                foo(x+1,y);
            }

            return;
        }

        for(int v = 1; v <=9 ; v++)
        {
            boolean flag = true;
            for(int i = 0; i < 9;i++)
            {
                if(arr[y][i] == v || arr[i][x] == v)
                {
                    flag = false;
                    break;
                }
            }

            int sx = (x/3)*3;
            int sy = (y/3)*3;
            for(int i = 0 ; i < 3;i++)
            {
                for(int j = 0 ; j < 3;j++)
                {
                    if(arr[sy+i][sx+j] == v)
                    {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag)
            {
                arr[y][x]=v;

                if(x == 8)
                {
                    foo(0,y+1);
                }
                else
                {
                    foo(x+1,y);
                }
                arr[y][x] = 0;
            }

        }


    }
    static int[][] arr = new int[9][9];
    static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0 ; i < 9;i++)
        {
            String s = br.readLine();
            for(int j = 0; j < 9 ; j++)
            {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        try
        {
            foo(0,0);
        }
        catch (Exception e)
        {

        }

        bw.flush();
    }
}

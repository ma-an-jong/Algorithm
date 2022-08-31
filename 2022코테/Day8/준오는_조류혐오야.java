package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 준오는_조류혐오야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int map[][] = new int[n+1][m+1];
        int total = 0;
        for(int i = 1 ; i <= n ;i++)
        {
            str = br.readLine().split(" ");
            for(int j = 1 ; j <= m ;j++)
            {
                map[i][j] = Integer.parseInt(str[j-1]);

                for(int k = 0 ; k < str[j-1].length();k++)
                {
                    if(str[j-1].charAt(k) == '9')
                    {
                        map[0][j]++;
                        map[i][0]++;
                        total++;
                    }
                }
            }
        }
        int max = 0;
        int x =0;
        int y =0;
//
//        System.out.println(total);
//        for(int i = 0; i <= n ; i++)
//        {
//            for(int j = 0 ; j <= m;j++)
//            {
//                System.out.printf("%5d",map[i][j]);
//            }픽
//            System.out.println();
//        }

        for(int i = 0 ; i <= m;i++)
        {
            if(map[0][i] > max)
            {
                max = map[0][i];
                x = i;
                y = 0;
            }
        }

        for(int i = 0 ; i <= n;i++)
        {
            if(map[i][0] > max)
            {
                max = map[i][0];
                x = 0;
                y = i;
            }
        }

        total -= map[y][x];

        System.out.println(total);


    }
}

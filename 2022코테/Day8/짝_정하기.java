package Day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 짝_정하기 {
    static class Pair{
        int x = 0;
        int y = 0;

        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pair[]> list = new ArrayList<>();
    static void perm(int N,int idx)
    {
        if(N == idx)
        {
            Pair arr[] = new Pair[N];
            for(int i = 0 ; i < N;i++)
            {
                arr[i] = new Pair(select[i].x,select[i].y);
            }
            list.add(arr);
            return;
        }

        for(int i = 0 ; i < N;i++)
        {
            if(!visited[i])
            {
                select[idx] = arr[i];
                visited[i] = true;
                perm(N,idx+1);
                visited[i] = false;
            }
        }
    }

    static Pair arr[] = new Pair[6];
    static Pair select[] = new Pair[6];
    static boolean visited[] = new boolean[6];
    static int count[][] = new int[3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int m[] = new int[3];
        int f[] = new int[3];

        int cursor = 0;
        for(int i = 0 ; i < 3;i++)
        {
            for(int j = 0 ; j < 3;j++)
            {
                if(i == j) continue;
                arr[cursor++] = new Pair(i,j);
            }
        }

        perm(6,0);

        for(int i =0 ; i < 3;i++)
        {
            String str[] = br.readLine().split(" ");
            m[i] = Integer.parseInt(str[0]);
            f[i] = Integer.parseInt(str[1]);
        }

        for(int k = 0 ; k < list.size();k++)
        {
            int man[] = new int[3];
            int woman[] = new int[3];

            for(int i = 0 ; i < 3; i++)
            {
                man[i] = m[i];
                woman[i] = f[i];

                for(int j = 0; j < 3; j++)
                {
                    count[i][j] =0;
                }
            }

            Pair arr[] = list.get(k);

            for(int i = 0 ; i < arr.length;i++)
            {
                int x = arr[i].x;
                int y = arr[i].y;

                int v = Math.min(man[x],woman[y]);

                man[x] -=v;
                woman[y] -=v;
                count[x][y] +=v;
            }

            boolean flag = true;

            for(int i = 0;i < 3;i++)
            {
                if(man[i] != 0 || woman[i] != 0)
                {
                    flag = false;
                }
            }

            if(flag)
            {
                bw.write("1\n");
                for(int i = 0 ; i < 3;i++)
                {
                    for(int j = 0 ; j < 3;j++)
                    {
                        if(i == j) continue;
                        bw.write(count[i][j] +" ");
                    }
                    bw.write("\n");
                }

                bw.flush();
                break;
            }
        }

        bw.write("0\n");

    }
}

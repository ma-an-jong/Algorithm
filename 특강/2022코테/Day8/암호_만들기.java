package Day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 암호_만들기 {
    static boolean valid(char c)
    {
        if(c == 'a' || c == 'e' || c== 'i' || c == 'o' || c== 'u')
        {
            return true;
        }
        return false;
    }

    static void perm(int cnt) throws Exception
    {
        if(cnt == L)
        {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int count = -1;
            for(int i = 0 ; i < L;i++)
            {
                sb.append(select[i]);
                if(count >= select[i] - 'a') return;
                count = select[i] - 'a';
                if(valid(select[i])) flag = true;
            }

            if(!flag) return;

            bw.write(sb.toString());
            bw.write("\n");
            return;
        }


        for(int i = 0 ; i< C;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                select[cnt] = str[i].charAt(0);
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }
    static void comb(int idx,int cnt) throws Exception
    {
        if(cnt > L) return;

        if(idx == C)
        {
            if(cnt == L)
            {
                StringBuilder sb = new StringBuilder();
                boolean flag = false;
                int count = 0;
                for(int i = 0 ; i < C;i++)
                {
                    if(visited[i])
                    {
                        char c = str[i].charAt(0);
                        sb.append(c);
                        if(valid(c)) flag = true;
                        else count++;
                    }
                }

                if(!flag) return;
                if(count < 2) return;

                bw.write(sb.toString());
                bw.write("\n");
            }
            return;
        }

        visited[idx] = true;
        comb(idx+1,cnt+1);
        visited[idx] = false;
        comb(idx+1,cnt);
    }
    static int L;
    static int C;
    static boolean visited[];
    static char select[];
    static String str[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split(" ");

        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        visited = new boolean[C];
        select = new char[C];
        str = br.readLine().split(" ");
        Arrays.sort(str);
        comb(0,0);
        bw.flush();
        bw.close();

    }
}

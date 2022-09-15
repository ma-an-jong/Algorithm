package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class _1의개수세기 {
    static long count(long A)
    {
        if(A <= 1) return A;

        long i = 1;
        int cnt = 0;

        for(; i <= A/2;i<<=1)
        {
            cnt++;
        }

        return list.get(cnt-1)+ (A - i + 1) + count(A - i);
    }
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str= br.readLine().split(" ");
        long A = Long.parseLong(str[0]);
        long B = Long.parseLong(str[1]);
        list = new ArrayList<>();
        long last = 1;
        list.add(1L);

        for(long i = 1,j = 1; j < 56;i *= 2,j++)
        {
            last = last*2 + i*2;
            list.add(last);
        }

        bw.write(String.valueOf(count(B) - count(A-1)));
        bw.flush();
    }
}



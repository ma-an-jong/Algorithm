package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 구간_합_구하기 {
    static long heap[];
    static int N;
    static int start = 1;

    static long solve(int idx,int currentLeft,int currentRight,int left,int right)
    {
        if(currentLeft >= left && currentRight <= right) return heap[idx];

        if(currentLeft > right) return 0;
        if(currentRight < left) return 0;
        long l = solve(idx*2 , currentLeft , (currentLeft+currentRight)/2 ,left,right);
        long r = solve(idx*2+1, (currentLeft + currentRight)/2 + 1 , currentRight ,left,right);

        return l + r;
    }

    static long setTree(int idx,long value)
    {
        heap[idx] = value;

        while(idx != 1)
        {
            idx /= 2;
            heap[idx] = heap[idx*2] + heap[idx*2+1];
        }



        return heap[idx];
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);

        while(start < N)
        {
            start *= 2;
        }

        heap = new long[start*2];

        int cursor = start;

        for(int i = 0 ; i < N;i++)
        {
            long x = Long.parseLong(br.readLine());
            setTree(cursor++,x);
        }

        for(int i = 0 ; i < M+K;i++)
        {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            long c = Long.parseLong(str[2]);

            if(a == 1)
            {
                setTree(start+b-1 , (long)c);
            }
            else
            {
                long ans = solve(1,0,start-1,b-1,(int)(c-1));
                bw.write(ans+"\n");
            }


        }

        bw.flush();










    }
}

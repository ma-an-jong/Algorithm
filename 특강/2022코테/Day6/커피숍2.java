package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 커피숍2 {
    static int N;
    static int start = 1;
    static long heap[];

    static void setTree(int idx,long value)
    {
        heap[idx] = value;

        while(idx != 1)
        {
            idx /= 2;
            heap[idx] = heap[idx*2] + heap[idx*2 + 1];
        }
    }

    static long solve(int idx,int currentLeft,int currentRight,int left,int right)
    {
        if(left <= currentLeft && currentRight <= right) return heap[idx];

        if(currentLeft > right) return 0;
        if(currentRight < left) return 0;

        long l = solve(idx*2 , currentLeft,(currentRight + currentLeft)/2 , left,right);
        long r = solve(idx*2 + 1, (currentLeft + currentRight)/2 + 1,currentRight,left,right);

        return l + r;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int Q = Integer.parseInt(str[1]);


        while(start < N)
        {
            start*=2;
        }
        int cursor = start;

        heap = new long[start*2];
        str = br.readLine().split(" ");

        for(int i = 0 ; i < N;i++)
        {
            setTree(cursor++,Long.parseLong(str[i]));
        }

        for(int i = 0 ; i < Q;i++)
        {
            str = br.readLine().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            if(x > y)
            {
                int tmp = x;
                x = y;
                y= tmp;
            }

            int a = Integer.parseInt(str[2]);
            long b = Long.parseLong(str[3]);

            long ans = solve(1,0,start - 1,x-1,y-1);
            bw.write(ans+"\n");
            setTree(a + start - 1,b);
        }

        bw.flush();

    }
}

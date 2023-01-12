package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 최솟값 {
    static long heap[];
    static int start = 1;
    static int N;

    static long solve(int idx,int currentLeft,int currentRight,int left,int right){
        if(currentLeft >= left && currentRight <= right) return heap[idx];

        if(currentLeft > right) return Integer.MAX_VALUE;
        if(currentRight < left) return Integer.MAX_VALUE;

        long l = solve(idx*2 , currentLeft,(currentRight + currentLeft) / 2, left,right);
        long r = solve(idx*2 + 1 ,(currentRight + currentLeft) / 2 + 1, currentRight,left,right);

        return Math.min(l,r);
    }

    static void setTree(int idx,long value)
    {
        heap[idx] = value;

        while(idx != 1)
        {
            idx /= 2;
            heap[idx] = Math.min(heap[idx*2],heap[idx*2 + 1]);
        }

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);


        while(start < N)
        {
            start *=2;
        }

        heap = new long[2*start];

        Arrays.fill(heap,Integer.MAX_VALUE);

        int cursor = start;

        for(int i = 0 ; i < N;i++)
        {
            long value = Long.parseLong(br.readLine());
            setTree(cursor++,value);
        }

        for(int i = 0 ; i < M ;i++)
        {
            str = br.readLine().split(" ");
            int left = Integer.parseInt(str[0]);
            int right = Integer.parseInt(str[1]);

            long ans = solve(1,0,start-1,left-1,right-1);
            bw.write(ans + "\n");
        }

        bw.flush();
    }
}

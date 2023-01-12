package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 영화_수집 {

    static int n;
    static int start;
    static long heap[];

    static void setTree(int idx, long value){
        heap[idx] = value;

        while(idx != 1)
        {
            idx /= 2;
            heap[idx] = heap[2*idx] + heap[2*idx+1];
        }

    }

    static long solve(int idx,int currentLeft,int currentRight,int left,int right)
    {
        if(currentLeft >= left && right >= currentRight) return heap[idx];

        if(currentLeft > right) return 0;
        if(currentRight < left) return 0;

        long l = solve(idx*2, currentLeft , (currentLeft+currentRight)/2,left,right);
        long r = solve(idx*2 + 1, (currentLeft + currentRight)/2 +1 ,currentRight, left,right);
        return l + r;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase =Integer.parseInt(br.readLine());

        for(int t = 0 ; t< testcase ; t++)
        {
            String input[] = br.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            start = 1;

            while(start < (n+m)*2){
                start *= 2;
            }

            heap = new long[start*2*10];

            int cursor = start;
            for(int i = 0 ; i < n;i++)
            {
                setTree(cursor++,1);
            }

            input = br.readLine().split(" ");

            int arr[] = new int[n+1];

            for(int i = n; i > 0 ; i--)
            {
                arr[i] = n-i;
            }

            for(int i = 0 ; i < m ; i++)
            {
                int q = Integer.parseInt(input[i]);

                int idx = arr[q];
                arr[q] = n+i;

                long ans = solve(1,0,start-1,idx+1,n+i);

                setTree(idx + start,0);
                setTree(cursor++,1);
                bw.write(ans + " ");
            }

            bw.newLine();
        }

        bw.flush();
    }
}

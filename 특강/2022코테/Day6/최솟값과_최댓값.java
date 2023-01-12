package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 최솟값과_최댓값 {

    static class Node{
        long min;
        long max;

        Node(long min,long max)
        {
            this.min = min;
            this.max = max;
        }

    }

    static Node heap[];
    static int start = 1;
    static int N;

    static Node solve(int idx,int currentLeft,int currentRight,int left,int right){
        if(currentLeft >= left && currentRight <= right) return heap[idx];

        if(currentLeft > right) return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE);
        if(currentRight < left) return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE);

        Node l = solve(idx*2 , currentLeft,(currentRight + currentLeft) / 2, left,right);
        Node r = solve(idx*2 + 1 ,(currentRight + currentLeft) / 2 + 1, currentRight,left,right);

        long min = Math.min(l.min,r.min);
        long max = Math.max(l.max,r.max);

        return new Node(min,max);
    }

    static void setTree(int idx,Node value)
    {
        heap[idx] = value;

        while(idx != 1)
        {
            idx /= 2;
            Node l = heap[idx*2];
            Node r = heap[idx*2 + 1];

            long min = Math.min(l.min,r.min);
            long max = Math.max(l.max,r.max);

            heap[idx] = new Node(min,max);
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

        heap = new Node[2*start];

        Arrays.fill(heap,new Node(Integer.MAX_VALUE,Integer.MIN_VALUE));

        int cursor = start;

        for(int i = 0 ; i < N;i++)
        {
            long value = Long.parseLong(br.readLine());
            setTree(cursor++,new Node(value,value));
        }

        for(int i = 0 ; i < M ;i++)
        {
            str = br.readLine().split(" ");
            int left = Integer.parseInt(str[0]);
            int right = Integer.parseInt(str[1]);

            Node ans = solve(1,0,start-1,left-1,right-1);
            bw.write(ans.min + " " + ans.max + "\n");
        }

        bw.flush();
    }
}

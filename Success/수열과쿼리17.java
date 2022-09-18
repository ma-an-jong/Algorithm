package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 수열과쿼리17 {
    static int N;
    static int start = 1;
    static int[] tree;
    static int init = 1000000001;
    static int find(int index,int currentLeft,int currentRight,int leftBound,int rightBound)
    {
        if(currentLeft >= leftBound && currentRight <= rightBound) return tree[index];

        if(currentLeft > rightBound) return Integer.MAX_VALUE;
        if(currentRight < leftBound) return Integer.MAX_VALUE;

        int l = find(index*2,currentLeft,(currentLeft+currentRight)/2 , leftBound,rightBound);
        int r = find(index*2 + 1,(currentLeft+currentRight)/2 + 1, currentRight,leftBound,rightBound);

        return Math.min(l,r);
    }
    static void setTree(int index,int value)
    {
        tree[index] = value;
        while(index != 0)
        {
            index /= 2;
            tree[index] = Math.min(tree[index*2],tree[index*2+1]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        while(start < N)
        {
            start *= 2;
        }
        tree = new int[start*3];
        Arrays.fill(tree,init);
        String[] str = br.readLine().split(" ");
        for(int i = start ; i < start + N ; i++)
        {
            setTree(i , Integer.parseInt(str[i-start]));
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++)
        {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a == 1)
            {
                setTree(start+b-1,c);
            }
            else
            {
                bw.write(find(1,0,start-1,b-1,c-1)+"\n");
            }
        }
        bw.flush();

    }
}

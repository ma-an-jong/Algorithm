package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class 수열과_쿼리16 {

    static class Pair{
        int v;
        int idx;

        Pair(int v,int idx)
        {
            this.v = v;
            this.idx = idx;

        }

    }

    static void setTree(Pair arr[] , int idx,Pair v)
    {
        arr[idx] = new Pair(v.v,v.idx);

        while(idx != 1)
        {
            idx /= 2;

            if(arr[idx*2].v > arr[idx*2 + 1].v)
            {
                arr[idx] = new Pair(arr[idx*2 + 1].v,arr[idx*2 + 1].idx);
            }
            else if(arr[idx*2].v == arr[idx*2 + 1].v)
            {
                if(arr[idx*2+ 1].idx > arr[idx*2].idx)
                {
                    arr[idx] = new Pair(arr[idx*2].v,arr[idx*2].idx);
                }
                else
                {
                    arr[idx] = new Pair(arr[idx*2+1].v,arr[idx*2+1].idx);
                }
            }
            else
            {
                arr[idx] = new Pair(arr[idx*2].v,arr[idx*2].idx);
            }
        }

    }

    static Pair foo(Pair arr[],int idx,int currentLeft,int currentRight,int left,int right)
    {
        if(left <= currentLeft && currentRight <= right) return new Pair(arr[idx].v,arr[idx].idx);

        if(left > currentRight) return new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
        if(right < currentLeft) return new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);

        Pair l = foo(arr,idx*2,currentLeft,(currentLeft + currentRight) /2,left,right );
        Pair r = foo(arr,idx*2 + 1,(currentLeft + currentRight)/2 + 1,currentRight,left,right );

        if(l.v == r.v)
        {
            if(l.idx > r.idx)
            {
                return new Pair(r.v,r.idx);
            }
            else
            {
                return new Pair(l.v,l.idx);
            }
        }
        else if(l.v > r.v)
        {
            return new Pair(r.v,r.idx);
        }
        else
        {
            return new Pair(l.v,l.idx);
        }
    }

    static int start = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str[]= br.readLine().split(" ");

        while(start < N)
        {
            start *= 2;
        }

        Pair arr[] =new Pair[2*start];

        for(int i = 0 ; i < arr.length;i++)
        {
            arr[i] = new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }

        for(int i = 0; i < N;i++)
        {
            int v = Integer.parseInt(str[i]);
            setTree(arr,start + i,new Pair(v,i+1));
        }


        int M = Integer.parseInt(br.readLine());
//        Arrays.stream(arr).forEach(v-> System.out.println(v.v+ " " + v.idx));
        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a == 1)
            {
                setTree(arr,start + b-1,new Pair(c,arr[start + b-1].idx));
            }
            else
            {
                Pair p = foo(arr,1,0,start - 1,b-1,c-1);
//                System.out.println(p.v + " " + p.idx);
                bw.write(p.idx+"\n");
            }
        }

        bw.flush();
        bw.close();



    }
}

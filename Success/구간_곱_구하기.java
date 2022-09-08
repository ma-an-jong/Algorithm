package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구간_곱_구하기 {

    static int d = 1000000007;
    static long arr[];
    static void setTree(int idx, long value)
    {
        arr[idx] = value % d;

        while(idx != 0)
        {
            idx /= 2;
            arr[idx] = (arr[idx*2] %d)* (arr[idx*2+1]%d) % d ;
        }
    }

    static long solve(int idx, int currentLeft,int currentRight, int left,int right)
    {
        if(left <= currentLeft && currentRight <= right) return arr[idx];
        if(currentLeft > right) return 1;
        if(currentRight < left) return 1;

        long l = solve(idx*2, currentLeft, (currentLeft + currentRight)/2 , left,right) % d;
        long r = solve(idx*2+1, (currentLeft + currentRight)/2 + 1, currentRight , left,right) % d;
        return (l*r) % d;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); int M = Integer.parseInt(str[1]); int K = Integer.parseInt(str[2]);
        int start = 1;
        while(start < N)
        {
            start*=2;
        }
        arr = new long[start*3];
        for(int i = start ; i < start + N;i++)
        {
            arr[i] = 1;
        }
        for(int i = 0 ; i < N;i++)
        {
            setTree(start+i,Long.parseLong(br.readLine()));
        }
        for(int i = 0 ; i < M + K;i++)
        {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            long c = Long.parseLong(str[2]);

//            for(int k = 0 ; k < arr.length;k++)
//            {
//                System.out.print(arr[k] + " ");
//            }
//            System.out.println();
            if(a == 1)
            {
                setTree(start+b-1,c);
//                for(int k = 0 ; k < arr.length;k++)
//                {
//                    System.out.print(arr[k] + " ");
//                }
//                System.out.println();
            }
            else
            {
                long ans = solve(1,0,start-1,b-1,(int)c-1);
                bw.write(ans + "\n");
            }
        }

        bw.flush();
    }
}

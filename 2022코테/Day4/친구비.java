package Day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Arrays;

public class 친구비 {


    static int find(int[] arr, int a)
    {
        if(arr[a] == a)
        {
            return a;
        }

        int ap = find(arr,arr[a]);
        arr[a] = ap;
        return ap;
    }

    static void union(int[] arr, int a,int b)
    {
        int ap = find(arr,a);
        int bp = find(arr,b);
        if(ap != bp)
        {
            if(cost[ap] < cost[bp]) arr[bp] = ap;
            else arr[ap] = bp;
        }

    }
    static int cost[];
    public static void main(String args[]) throws Exception{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);


        int arr[] = new int[N+1];
        cost = new int[N+1];

        str = br.readLine().split(" ");

        for(int i = 0 ; i < N ; i ++)
        {
            arr[i+1] = i+1;
            cost[i+1] = Integer.parseInt(str[i]);
        }

        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            union(arr,a,b);
        }

        int ans = 0;
        for(int i = 1; i <=N;i++)
        {
            if(arr[i] == i)
            {
                ans += cost[i];
            }
        }

        if(ans > K) System.out.println("Oh no");
        else System.out.println(ans);

    }
}

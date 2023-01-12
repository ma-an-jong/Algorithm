package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 양팔저울 {

    public static void comb(int N,int idx,int value)
    {
        if(N == idx)
        {
            if(!ans.contains(value))
            {
                ans.add(value);
            }

            return;
        }

        select[idx] = 0;
        comb(N,idx+1,value+arr[idx]);
        comb(N,idx+1,Math.abs(value - arr[idx]));
        select[idx] = 1;
        comb(N,idx+1,value);

    }

    static int select[];
    static int arr[];
    static Set<Integer> ans = new HashSet<>();
    static int max = 0;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");

        arr = new int[k];
        select = new int[k];

        for(int i = 0 ; i < k;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
            max += arr[i];
        }

        comb(k,0,0);
        int count = 0;

        for(int i = 1 ; i <= max; i++)
        {
            if(!ans.contains(i))
            {
                count++;
            }
        }
        System.out.println(count);
    }
}

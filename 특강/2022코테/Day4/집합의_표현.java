package Day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 집합의_표현 {

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
            arr[ap] = bp;
        }

    }

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int arr[] = new int[N+1];
        for(int i = 1 ; i <= N;i++)
        {
            arr[i] = i;
        }
        for(int i = 0 ; i < M;i++)
        {
            str = br.readLine().split(" ");

            int o = Integer.parseInt(str[0]);

            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);

            if(o == 0)
            {
                union(arr,a,b);
            }
            else {
                if(find(arr,a) == find(arr,b))
                {
                    bw.write("YES" + "\n");
                }
                else
                {
                    bw.write("NO" + "\n" );
                }
            }
        }


        bw.flush();


    }
}

package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 공항 {

    static int find(int[] arr,int a)
    {
        if(arr[a] != a)
        {
            arr[a] = find(arr,arr[a]);
        }
        return arr[a];
    }

    static void union(int[] arr,int a ,int b)
    {
        if(arr[a] != arr[b])
        {
            int ap = arr[a];
            int bp = arr[b];

            arr[bp] = ap;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] gate = new int[G+1];
        for(int i = 1 ; i <= G;i++) gate[i] = i;
        int cnt = 0;
        for(int i = 0 ; i < P;i++)
        {
            int v = Integer.parseInt(br.readLine());
            int x = find(gate,v);
            if(x == 0)break;
            cnt++;
            union(gate,x-1,x);
        }
        System.out.println(cnt);

    }
}

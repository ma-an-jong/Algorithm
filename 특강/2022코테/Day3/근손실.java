package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 근손실 {

    static void perm(int N,int K, int count)
    {
        if(N == count)
        {
            int sum  =500;
            for(int i = 0 ; i < select.length;i++)
            {
                sum+= select[i];
                sum-= K;

                if(sum < 500 )return;
            }

            ans++;

            return;
        }

        for(int i = 0; i < N; i++)
        {
            if(visited[i] == 0)
            {
                select[count] = arr[i];
                visited[i] = 1;
                perm(N,K,count+1);
                visited[i] = 0;
            }
        }
    }

    static int visited[];
    static int select[];
    static int arr[];
    static int ans = 0;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        arr = new int[N];
        select = new int[N];
        visited = new int[N];

        for(int i = 0; i < N ; i ++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }

        perm(N,K,0);

        System.out.println(ans);


    }
}

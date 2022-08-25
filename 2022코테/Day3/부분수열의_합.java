package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부분수열의_합 {

    static void comb(int N,int R,int idx,int c)
    {
        if(N == idx)
        {
            if(c == R)
            {
                boolean flag = false;
                int sum = 0;
                for(int i = 0 ; i < N;i++)
                {
                    if(select[i] == 1){
                        flag = true;
                        sum += arr[i];
                    }
                }

                if(sum == S && flag)
                {
                    count++;
                }
            }

            return;
        }

        select[idx] = 0;
        comb(N,R,idx+1,c);
        select[idx] = 1;
        comb(N,R,idx+1,c+1);
    }

    static int arr[] ;
    static int select[];
    static boolean visited[];
    static int N;
    static int S;
    static int count;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

         N = Integer.parseInt(str[0]);
         S = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        arr = new int[N];
        select = new int[N];
        visited = new boolean[N];

        for(int i = 0 ; i < N; i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }

        count = 0;
        for(int i = 1 ; i <= N;i++)
        {
            select = new int[N];
            visited = new boolean[N];
            comb(N,i,0,0);
        }

        System.out.println(count);


    }
}

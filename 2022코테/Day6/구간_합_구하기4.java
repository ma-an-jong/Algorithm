package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 구간_합_구하기4 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int arr[] = new int[N+1];

        str = br.readLine().split(" ");

        for(int i = 1; i <= N ; i++)
        {
            arr[i] = Integer.parseInt(str[i-1]);
        }

        for(int i = 1; i <= N;i++)
        {
            arr[i] = arr[i-1] + arr[i];
        }

        for(int i = 0 ;i < M;i++)
        {
            str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            int ans = arr[b] - arr[a-1];
            bw.write(ans+"\n");
        }
            bw.flush();



    }
}

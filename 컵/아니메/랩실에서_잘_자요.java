package Algorithm.컵.아니메;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 랩실에서_잘_자요 {
    static int N;
    static int M;
    static int[][] dp;

    static int foo(boolean[] arr, int index,int seq) {
        if(index == 0) {
            boolean[] tmp = Arrays.copyOf(arr,N+1);

            for (int i = 1; i <= seq; i++) {
                tmp[index + i] = true;
            }

            boolean flag = true;

            for (int i = 1; i <= N; i++) {
                flag &= tmp[i];
            }

            if(flag) {
               return seq != 0 ? 5 + 2*seq : 0;
            }

            return 7*10000;
        }

        if(dp[index][seq] != 0) return dp[index][seq];

        boolean[] tmp = Arrays.copyOf(arr,N+1);

        int x = foo(tmp,index-1,seq+1);

        if(arr[index]) {

            for (int i = 1; i <= seq; i++) tmp[index+i] = true;

            x = Math.min(x,
                    foo(tmp,index-1,0) + (seq == 0 ? 0 : 5 + 2*(seq)));
        } else {
            for (int i = 0; i <= seq; i++) tmp[index+i] = true;
            x = Math.min(foo(tmp,index-1,0) + 5 + 2*(seq+1),x);
        }

        dp[index][seq] = x;
        return dp[index][seq];
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str =  br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        boolean[] arr = new boolean[N+1];
        str = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int page = Integer.parseInt(str[i]);
            arr[page] = true;
        }

        dp = new int[N+1][N+1];
        int x = foo(arr,N,0);
        System.out.println(x);
    }
}

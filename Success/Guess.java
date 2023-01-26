package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Guess {
    static int N;
    static char[][] arr;
    static int[][] sum;
    static int[] select;
    static boolean flag = true;
    static StringBuilder ans = new StringBuilder();

    static int get(int i,int j){
        if(j < 0) return 0;
        return sum[i][j];
    }
    static void foo(int n) {
        if(n == N) {

            for (int i = 0; i < N; i++) {
                ans.append(select[i]+" ");
            }
            flag = false;
            return;
        }

        for (int i = -10; i <= 10; i++) {
            if(flag){
                boolean valid = true;
                for (int j = 0; j <= n; j++) {
                    sum[j][n] = get(j,n-1) + i;

                    if(arr[j][n] == '-' && sum[j][n] < 0) ;
                    else if(arr[j][n] == '+' && sum[j][n] > 0) ;
                    else if(arr[j][n] == '0' && sum[j][n] == 0) ;
                    else valid = false;
                }

                if(valid) {
                    select[n] = i;
                    foo(n+1);
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int index = 0;
        arr = new char[N][N];
        sum = new int[N][N];
        select = new int[N];
        for (int i = N; i > 0; i--) {
            for (int j = N-i; j < N; j++) {
                arr[N-i][j] = line.charAt(index++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        foo(0);
        System.out.println(ans.toString());


    }
}

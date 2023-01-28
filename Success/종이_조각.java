package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 종이_조각 {

    static int N;
    static int M;
    static int[][] arr;

    static int[] select;
    static int ans = Integer.MIN_VALUE;
    static void foo(int n){

        if(n == N*M) {
            int[][] map = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = select[i*M + j];
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) {
                        tmp*= 10;
                        tmp += arr[i][j];
                    }
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }

                sum += tmp;
            }

            for (int i = 0; i < M; i++) {
                int tmp = 0;
                for (int j = 0; j < N; j++) {
                    if(map[j][i] == 1) {
                        tmp *= 10;
                        tmp += arr[j][i];
                    }
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }
                sum += tmp;
            }
            ans = Math.max(ans,sum);
            return;
        }

        select[n] = 1;
        foo(n+1);
        select[n] = 0;
        foo(n+1);

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        select = new int[N*M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        foo(0);
        System.out.println(ans);
    }
}

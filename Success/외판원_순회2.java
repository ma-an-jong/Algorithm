package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 외판원_순회2 {

    static int N;
    static int[][] arr;
    static int[] select;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void foo(int n) {
        if(n == N) {
            int sum = 0;

            for (int i = 0; i < N-1; i++) {
                int tmp = arr[select[i]][select[i+1]];
                if(tmp == 0) return;
                sum += tmp;
            }

            int re = arr[select[N-1]][select[0]];
            if(re != 0){
                min = Math.min(min,sum + re);
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[n] = i;
                foo(n+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        select = new int[N];
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        foo(0);
        System.out.println(min);
    }
}

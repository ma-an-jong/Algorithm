package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 차이를_최대로 {
    static int N;
    static int[] arr;
    static int[] select;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static void foo(int n){
        if(n == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(select[i] - select[i+1]);
            }

            max = Math.max(sum,max);
            return;
        }


        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[n] = arr[i];
                foo(n+1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        select = new int[N];
        visited = new boolean[N];

        foo(0);
        System.out.println(max);

    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 부등호 {

    static int N;
    static String[] arr;
    static boolean[] visited;
    static int[] select;
    static String max;
    static String min;

    static void foo(int n,int before) {
        if(n == N+1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N+1; i++) {
                sb.append(select[i]);
            }

            if(max.compareTo(sb.toString()) < 0) {
                max = sb.toString();
            }

            if(min.compareTo(sb.toString()) > 0) {
                min = sb.toString();
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if((arr[n].equals(">") && (before > i)) || (arr[n].equals("<") && (before < i))) {
                    select[n] = i;
                    foo(n+1,i);
                }

                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N+1];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i+1] = str[i];
        }
        visited = new boolean[10];
        select = new int[N+1];
        max = "0";
        min = "99999999999999999999";

        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            select[0] = i;
            foo(1,i);
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 로마_숫자_만들기 {



    static final int MAX = 50*20;
    static int N;
    static int cnt = 0;
    static boolean[] arr = new boolean[MAX+1];
    static List<Integer> list = List.of(1,5,10,50);
    static void foo(int n,int sum) {

        if(sum > MAX) return;
        if(n == N) {
            if(!arr[sum]) {
                arr[sum] = true;
                cnt++;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            foo(n+1,sum + list.get(i));
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> before = List.of(0);

        for (int i = 0; i < N; i++) {
            boolean visited[] = new boolean[MAX+1];
            List<Integer> after = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < before.size(); k++) {
                    int next = before.get(k) + list.get(j);
                    if(next <= MAX && !visited[next]) {
                        visited[next] = true;
                        after.add(next);
                    }
                }
            }
            before = after;
        }

        System.out.println(before.size());

    }
}

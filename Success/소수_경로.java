package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 소수_경로 {

    static boolean[] prime = new boolean[10000];

    static int parseInt(int[] a) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum *= 10;
            sum += a[i];
        }

        return sum;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(prime,true);

        for (int i = 2; i* i < 10_000; i++) {
            if(!prime[i]) continue;

            for (int j = i*i; j < 10_000; j += i) {
                prime[j] = false;
            }
        }

        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {

            String[] str = br.readLine().split(" ");
            int[] A = new int[4];

            for (int i = 0; i < 4; i++) {
                A[i] = str[0].charAt(i) - '0';
            }

            int B = Integer.parseInt(str[1]);

            int[] visited = new int[10000];
            Arrays.fill(visited,Integer.MAX_VALUE);

            for (int i = 0; i < 10000; i++) {
                if(!prime[i]) {
                    visited[i] = Integer.MIN_VALUE;
                }
            }

            Queue<int[]> q = new ArrayDeque<>();
            Queue<Integer> c = new ArrayDeque<>();
            q.add(A); c.add(0);
            boolean flag = true;
            visited[parseInt(A)] = 0;

            while (flag && !q.isEmpty()) {
                int[] x = q.remove();
                int value = parseInt(x);
                int cost = c.remove();

                if(value == B) {
                    System.out.println(cost);
                    flag = false;
                    continue;
                }


                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        int[] next = Arrays.copyOf(x,4);
                        next[i] = j;

                        if(next[0] == 0) continue;
                        int n = parseInt(next);
                        if(visited[n] <= cost + 1) continue;
                        visited[n] = cost + 1;
                        q.add(next); c.add(cost + 1);
//                        System.out.println(value +" -> " + next);

                    }
                }
            }

            if(flag){
                System.out.println("Impossible");
            }


        }

    }
}

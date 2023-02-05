package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 부분수열의_합 {
    static int N;
    static int[] arr;
    static Set<Integer> ans;
    static boolean[] visited;
    static void foo(int i,int sum) {
        if(i == N ){
            if(sum != 0) ans.add(sum);
            return;
        }

        foo(i+1,sum);
        foo(i+1,sum+arr[i]);
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new TreeSet<>();

        visited = new boolean[N];

        foo(0,0);

        for (int i = 1; i <= 100_000*20+1; i++) {
            if(!ans.contains(i)){
                System.out.println(i);
                return;
            }
        }
    }
}

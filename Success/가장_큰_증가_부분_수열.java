package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_큰_증가_부분_수열 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + arr[i]);
                }
            }
        }
        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}

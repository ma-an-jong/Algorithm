package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_긴_감소하는_부분_수열 {

    static int foo(int[] dp,int v){
        int start = 0;
        int end = dp.length;

        while(start < end){
            int mid = (start + end)/2;

            if(v <= dp[mid]){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }

        return end;


    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE);
        String[] str = br.readLine().split(" ");

        for (int i = str.length-1; i >= 0; i--) {
            int v = Integer.parseInt(str[i]);
            int index = foo(dp,v);

            dp[index] = v;
        }

        int cnt = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] != Integer.MAX_VALUE){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}

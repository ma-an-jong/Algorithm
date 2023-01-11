package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 오등큰수 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] count = new int[1_000_001];
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str[i-1]);
            count[arr[i]]++;
        }

        Stack<Integer> s = new Stack<>();

        int[] ans = new int[N+1];
        ans[N] = -1;
        s.push(arr[N]);

        for (int i = N-1; i > 0 ; i--) {
            while(!s.isEmpty() && count[s.peek()] <= count[arr[i]]){
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();





    }
}

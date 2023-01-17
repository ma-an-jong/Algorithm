package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수_이어_쓰기1 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= N; i*=10) {
            String s = String.valueOf(i);
            ans += s.length()*(Math.min(i*9,N-i+1));
        }


        System.out.println(ans);
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AB {
    static int N;
    static int K;
    static String ans = null;

    static void foo(int i,String s,int a,int total) {

        if(ans != null) return;
        if(total > K) return;

        if (i == N) {
            if(total == K) {
                ans = s;
            }
            return;
        }

        foo(i+1,s+'A',a+1,total);
        foo(i+1,s+'B',a,total + a);

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        for (int a = 0; a <= N; a++) {
            int b = N - a;

            if(a*b >= K) {
                StringBuilder sb = new StringBuilder();
                if(a == 0) {
                    for (int i = 0; i < b; i++) {
                        sb.append('B');
                    }
                    System.out.println(sb.toString());
                    return;
                }
                int cnt = 0;

                while(b < K) {
                    sb.append("A");
                    K -= b;
                    cnt++;
                }

                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < b; i++) {
                    tmp.append('B');
                }
                tmp.insert(b-K,'A');
                System.out.println(sb.toString() + tmp.toString());
                return;
            }

        }

        System.out.println(-1);


    }

}

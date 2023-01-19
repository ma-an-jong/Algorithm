package Algorithm.N과M;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M3 {
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[] select;
    static void foo(int i) throws Exception {
        if(i == M) {
            for (int j = 0; j < M; j++) {
                bw.write(select[j]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int j = 1; j <= N; j++) {
            select[i] = j;
            foo(i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        select = new int[N];
        foo(0);
        bw.flush();
    }
}

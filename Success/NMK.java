package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class NMK {
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        if(M + K - 2 >= N || N >= M*K + 1) {
            System.out.println(-1);
            return;
        }

        if(N == M) {
            for (int i = 1; i <= N; i++) {
                bw.write(i+ " ");
            }
            bw.flush();
            return;
        }

        if(N == K) {
            for (int i = N; i > 0; i--) {
                bw.write(i+ " ");
            }
            bw.flush();
            return;
        }

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i-1] = i;
        }
        List<Integer>[] list = new List[M];
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<Integer>();
        }
        N -= K;
        M --;
        int size = N  / M;
        int remain = N % M;

        for (int j = K; j >= 1; j--) {
            list[0].add(j);
        }

        int x = K+1;
        for (int i = 1; i < list.length; i++) {

            int last = x + size;

            if(remain > 0) {
                last ++;
                remain--;
            }

            for (int j = last-1; j >= x; j--) {
                list[i].add(j);
            }

            x = last;
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) + " ");
            }
        }
        bw.flush();
    }

}

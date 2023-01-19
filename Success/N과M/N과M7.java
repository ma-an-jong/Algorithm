package Algorithm.N과M;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N과M7 {
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[] arr;
    static int[] select;

    static void foo(int i,int cnt) throws Exception {
        if(cnt == M) {
            for (int j = 0; j < M; j++) {
                bw.write(select[j]+" ");
            }
            bw.write("\n");
            return;
        }

        if(i == N) return;


        for (int j = 0; j < N; j++) {
            select[cnt] = arr[j];
            foo(i+1,cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        select = new int[M];
        str = br.readLine().split(" ");
        arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        foo(0,0);
        bw.flush();

    }
}

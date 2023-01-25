package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 로또 {

    static int K;
    static int[] arr;
    static int[] select;
    static boolean[] visited;
    static BufferedWriter bw;
    static void foo(int k,int before) throws Exception {
        if(k == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(select[i] +" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < K; i++) {
            if(!visited[i] && arr[i] > before) {
                visited[i] = true;
                select[k] = arr[i];
                foo(k+1,arr[i]);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while(!(line=br.readLine()).equals("0")) {
            String[] str = line.split(" ");
            K = Integer.parseInt(str[0]);
            arr = new int[K];
            Arrays.sort(arr);
            select = new int[6];
            visited = new boolean[K];

            for (int i = 1; i <= K; i++) {
                arr[i-1] = Integer.parseInt(str[i]);
            }
            foo(0,0);
            bw.write("\n");
        }
        bw.flush();
    }
}

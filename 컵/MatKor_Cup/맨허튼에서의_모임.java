package Algorithm.컵.MatKor_Cup;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 맨허튼에서의_모임 {

    static int N;
    static int M;
    static long[][] arr;


    static long[] minDistance(int n, int k, long[][] point)
    {
        for (int i = 0; i < k; i++)
            Arrays.sort(point[i]);

        long[] ans = new long[k];

        for (int i = 0; i < k; i++)
            ans[i] = point[i][(int) Math.ceil((double)(n / 2))];

        return ans;
    }

    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new long[N][M];

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[j][i] = Long.parseLong(str[j]);
            }
        }

        long[] ans = minDistance(M,N,arr);

        long distance = 0;

        for (int i = 0; i < M; i++) {
            long tmp = 0;
            for (int j = 0; j < N; j++) {
                tmp += Math.abs(ans[j] - arr[j][i]);
            }
            distance += tmp;
        }

        bw.write(distance + "\n");
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] +" ");
        }
        bw.flush();




    }
}

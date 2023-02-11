package Algorithm.컵.아니메;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 주문은_토기입니까 {
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int togi = 0;
        int coffee = 0;
        int serving = 0;

        for (int i = 0; i <= N; i++) {

        }
    }
}

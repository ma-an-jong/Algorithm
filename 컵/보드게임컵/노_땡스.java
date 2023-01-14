package Algorithm.컵.보드게임컵;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 노_땡스 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int tmp = arr[0];
        int ans = 0;
        for (int i = 1; i < N; i++) {
            if(arr[i] - arr[i-1] == 1){

            }
            else {
                ans += tmp;
                tmp = arr[i];
            }
        }

        ans += tmp;

        System.out.println(ans);

    }
}

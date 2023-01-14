package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_긴_바이토닉_부분_수열 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[] increase = new int[N]; Arrays.fill(increase,1);
        int[] decrease = new int[N]; Arrays.fill(decrease,1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && increase[i] < increase[j] + 1){
                    increase[i] = increase[j]+1;
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = i+1; j < N; j++) {
                if(arr[i] > arr[j] && decrease[j] + 1 > decrease[i]){
                    decrease[i] = decrease[j] + 1;
                }
            }
        }

        int ans = 0;
//        for (int i = 0; i < N; i++) {
//            System.out.println(increase[i] + "/" + decrease[i]);
//        }


        for (int i = 0; i < N; i++) {
            ans = Math.max(ans , increase[i] + decrease[i] -1);

        }

        System.out.println(ans);



    }
}

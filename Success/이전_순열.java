package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 이전_순열 {
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        boolean isAscending = true;

        for (int i = 0; i < N-1; i++) {
            if (arr[i] > arr[i + 1]) {
                isAscending = false;
                break;
            }
        }

        if(isAscending) {
            System.out.println(-1);
            return;
        }

        for (int i = N-1; i > 0; i--) {
            if(arr[i] < arr[i-1]){
                Integer[] head = Arrays.copyOfRange(arr,0,i);
                Integer[] tail = Arrays.copyOfRange(arr,i,arr.length);

                Arrays.sort(tail,Collections.reverseOrder());

                for (int j = 0; j < tail.length; j++) {
                    if(tail[j] < head[i-1]) {
                        int tmp = tail[j];
                        tail[j]  = head[i-1];
                        head[i-1] = tmp;

                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < head.length; k++) {
                            sb.append(head[k]+ " ");
                        }

                        for (int k = 0; k < tail.length; k++) {
                            sb.append(tail[k] + " ");
                        }
                        System.out.println(sb.toString());
                        return;
                    }
                }

            }
        }








    }
}

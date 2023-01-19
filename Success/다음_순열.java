package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 다음_순열 {

    static int N;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        boolean isDescent = true;


        for (int i = 0; i < N-1; i++) {
            if (arr[i + 1] > arr[i]) {
                isDescent = false;
                break;
            }
        }

        if(isDescent) {
            System.out.println(-1);
            return;
        }

        for (int i = N-1; i > 0; i--) {
            if(arr[i] > arr[i-1]){
                int[] head = Arrays.copyOfRange(arr,0,i);
                int[] tail = Arrays.copyOfRange(arr,i,arr.length);

                Arrays.sort(tail);

                for (int j = 0; j < tail.length; j++) {
                    if(tail[j] > head[head.length-1]) {

                        int tmp = head[head.length-1];
                        head[head.length-1] = tail[j];
                        tail[j] = tmp;

                        for (int k = 0; k < head.length; k++) {
                            bw.write(head[k] + " ");
                        }

                        for (int k = 0; k < tail.length; k++) {
                            bw.write(tail[k]+" ");
                        }
                        bw.flush();
                        return;
                    }
                }


            }
        }



    }
}

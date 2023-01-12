package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 골드바흐_파티션 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseSize = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[1_000_001];
        Arrays.fill(arr,true);
        for (int i = 2; i < arr.length; i++) {
            if(!arr[i]) continue;
            for (int j = i*2; j < arr.length; j+=i) {
                arr[j] = false;
            }
        }

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 2; i <= N/2; i++) {
                if(arr[i] && arr[N-i]){
                    cnt++;
                }
            }
            bw.write(cnt+"\n");

        }
        bw.flush();
    }
}

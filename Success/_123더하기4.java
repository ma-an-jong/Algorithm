package Algorithm.Success;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _123더하기4 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int count[] = new int[10010];
        count[0] = 1;

        int[] d = new int[]{1,2,3};


        for(int j = 0 ; j < 3;j++){
            for(int i = 1; i <= 10000;i++){
                if(i - d[j] >= 0){
                    count[i] += count[i-d[j]];
                }
            }
        }

        for(int i = 0 ; i < t ;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(count[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

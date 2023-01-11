package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 골드바흐의_추측 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[1_000_001];

        Arrays.fill(prime,true);

        for (int i = 2; i < prime.length; i++) {
            if(!prime[i]) continue;
            for (int j = i*2; j < prime.length; j+=i) {
                prime[j] = false;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < prime.length; i++) {
            if(prime[i]) list.add(i);
        }


        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                bw.flush();
                return;
            }
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                int b = n - list.get(i);
                if(prime[b]) {
                    bw.write(n +" = " + a + " + " + b + "\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) bw.write("Goldbach's conjecture is wrong.\n");
        }




    }
}

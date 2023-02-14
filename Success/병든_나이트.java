package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 병든_나이트 {
    static int N;
    static int M;

    static int foo(){
        if(N == 1) {
            return 1;
        }

        if(N == 2) {
            return Math.min(4,(M+1)/2);
        }

        if(M < 7) {
            return Math.min(4,M);
        }

        return 4 + (M - 6);
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        System.out.println(foo());


    }
}

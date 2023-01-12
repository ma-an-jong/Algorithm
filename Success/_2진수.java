package Algorithm.Trying;

import Algorithm.Stub;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2진수 {
    static String foo(int i,String s){
        if(i == 0) return s;

        if(i % (-2) < 0){
            return "1" + foo(i/(-2) + 1,s);
        }

        return i%(-2) + foo(i/(-2),s);
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s = foo(N,"");
        if(N == 0) System.out.println(0);
        else
            System.out.println(new StringBuilder(s).reverse().toString());
    }
}

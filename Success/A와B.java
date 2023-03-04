package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와B {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(!T.equals(S)) {

            if(T.equals("") || T.length() <= S.length()) {
                System.out.println(0);
                return;
            }

            if(T.charAt(T.length()-1) == 'A') {
                T = T.substring(0,T.length() -1);
            } else {
                StringBuilder sb = new StringBuilder(T.substring(0,T.length()-1));
                sb.reverse();
                T = sb.toString();
            }
        }

        System.out.println(1);


    }
}

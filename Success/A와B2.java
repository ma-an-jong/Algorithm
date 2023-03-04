package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와B2 {
    static boolean flag = false;

    static void foo(String t,String S) {
        if(flag) return;

        if(t.equals(S)) {
            flag = true;
            return;
        }

        if(t.equals("") || t.length() <= S.length()) {
            return;
        }

        if(t.charAt(t.length()-1) == 'A') {
            foo(t.substring(0,t.length() -1),S);
        }

        if(t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t);
            sb.reverse();
            foo(sb.substring(0,t.length()-1),S);
        }

    }




    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();
        foo(T,S);
        if(flag) System.out.println(1);
        else System.out.println(0);



    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 리모컨 {

    static int N;
    static int M;
    static int cnt = Integer.MAX_VALUE;
    static HashSet<Character> button;

    static String target;
    static int gap = Integer.MAX_VALUE;


    static void foo(int index, String s){

        if(index >= target.length()-1 && !s.equals("")) {
            int a = Integer.parseInt(s);
            int gap = Math.abs(N-a);

            if(cnt > index + gap) {
                cnt = index + gap;
            }

            if(index > target.length()) return;
        }

        for (int i = 0; i <= 9; i++) {
            char c = (char)(i+'0');
            if(button.contains(c)) foo(index+1,c + s);
        }

    }
    static void pressChannel(){
        foo(0,"");
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        target = String.valueOf(N);

        button = new HashSet<>();
        for (int i = 0; i < 10; i++) button.add((char)(i+'0'));

        M = Integer.parseInt(br.readLine());
        if(M != 0) {
            String[] str = br.readLine().split(" ");
            for (String s : str) button.remove(s.charAt(0));
        }

        int channel = 100;
        pressChannel();
        cnt = Math.min(cnt,Math.abs(N-channel));

       // System.out.println("cnt = " + cnt);

        System.out.println(cnt);



    }
}

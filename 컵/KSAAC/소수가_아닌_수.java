package Algorithm.컵.KSAAC;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수가_아닌_수 {
    static int N;
    public static boolean foo(int n) {
        for (int i = 2; Math.pow(i,2) <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        for (int i = N; i <=1_000_000_000; i++) {
            if(!foo(i)) {
                System.out.println(i);
                return;
            }
        }



    }
}

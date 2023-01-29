package Algorithm.컵.MatKor_Cup;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 몇개고 {

    static int T;
    static int S;
    static int ans;

    static boolean foo(int t) {
        if(t >= 12 && t <= 16) return true;

        return false;
    }
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        T = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);

        boolean flag = foo(T);

        if(S == 1 || !flag) {
            ans = 280;
        }
        else if(S == 0 && flag) {
            ans = 320;
        }

        System.out.println(ans);


    }
}

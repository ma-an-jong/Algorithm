package Algorithm.컵.MatKor_Cup;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 선형_회귀는_너무_쉬워1 {

    static long foo(long a,long b){
        if(b == 0) return 0;
        if(a % b == 0) return b;
        return foo(b,a%b);
    }
    static int n;
    static int b;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);

        long x = 0;

        long y = 0;

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            x += Integer.parseInt(str[0]);
            y += b - Integer.parseInt(str[1]);
        }


        long tmp = -y;
        if(x == 0) {
            System.out.println("EZPZ");
            return;
        }

       if(Math.abs(tmp) % Math.abs(x) == 0) {
           System.out.println(tmp / x);
       }
       else {
           long gcd = foo(Math.abs(tmp),Math.abs(x));

           long top = tmp/gcd;
           long bot = x/gcd;

           if(top < 0 && bot < 0) {
               System.out.println(Math.abs(top) + "/" + Math.abs(bot));
           }
           else if(top < 0 || bot < 0){
               System.out.println("-"+Math.abs(top) + "/" + Math.abs(bot));
           }
           else{
               System.out.println( top+ "/" +bot );
           }
       }

    }
}

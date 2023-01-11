package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 조합_0의_개수 {

    static double foo(int n , int i){
        double cnt = 0;
        while(n >= i){
            cnt += n/i;
            n = n/i;
        }

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        double a = foo(n,5);
        double b = foo(n,2);

        double c = foo(n-m,5);
        double d = foo(n-m,2);

        double e = foo(m,5);
        double f = foo(m,2);
        System.out.println((int)Math.min((a-(c+e)),(b-(d+f))));

    }
}

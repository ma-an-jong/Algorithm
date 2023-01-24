package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카잉_달력 {
    static int gcd(int a,int b){
        if(b == 0){
            return a;
        }

        return gcd(b,a%b);
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            String[] str = br.readLine().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            int x = Integer.parseInt(str[2]);
            int y = Integer.parseInt(str[3]);

            int lcm = (M*N)/ gcd(M,N);

            int a = 1;
            int b = 1;
            int cnt = 1;

            while(a!=x){
                a++;
                b++;
                cnt++;
            }

            while(b > N){
                b-= N;
            }

            while(true){

                if(cnt > lcm) {
                    cnt = -1;
                    break;
                }

                if(b == y) {
                    break;
                }

                b += M;

                while(b > N){
                    b-= N;
                }

                cnt += M;

            }

            bw.write(cnt+"\n");

        }
        bw.flush();
    }
}

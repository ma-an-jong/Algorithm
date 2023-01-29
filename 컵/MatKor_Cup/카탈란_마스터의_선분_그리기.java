package Algorithm.컵.MatKor_Cup;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class 카탈란_마스터의_선분_그리기 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<BigInteger> set  =new TreeSet<>();
        BigInteger x = new BigInteger("2");
        for (int i = 0; i < 100; i++) {
            set.add(x.pow(i).add(BigInteger.valueOf(1)));
        }

        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            String line = br.readLine();

            if(line.equals("0") || line.equals("1")) {
                bw.write("1 0");
            }
            else {
                BigInteger a = new BigInteger(line);
                int cnt = 0;

                while(a.equals(new BigInteger("0"))) {
                    a = a.divide(new BigInteger("2")).add(new BigInteger("-1"));
                    cnt++;
                }

                if(cnt % 2 == 0) {
                    bw.write("0 1");
                }
                else {
                    bw.write("1 0");
                }
            }

            bw.write("\n");
        }

        bw.flush();
    }
}

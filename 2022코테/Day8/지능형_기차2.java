package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class 지능형_기차2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int now = 0;
        for(int i = 0 ; i < 10; i++)
        {
            String str[] = br.readLine().split(" ");

            int in = Integer.parseInt(str[1]);
            int out = Integer.parseInt(str[0]);

            now = now -  out;
            if(now + in > 10000)
            {
                now = 10000;
            }
            else
            {
                now += in;
            }

            if(max < now)
            {
                max = now;
            }

        }

        System.out.println(max);





    }
}

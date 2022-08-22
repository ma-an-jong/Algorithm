package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OX퀴즈 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        int N =Integer.parseInt(str);

        for(int i = 0 ; i < N ; i++)
        {
            str = br.readLine();
            int count = 0;
            int sum = 0;
            for(int j = 0 ; j < str.length(); j++)
            {
                if(str.charAt(j) == 'O')
                {
                    count++;
                    sum += count;
                }
                else {
                    count = 0;
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();


    }
}

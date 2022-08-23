package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카이사르_암호 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        char arr[] = new char[str.length()];

        for(int i= 0; i < str.length();i++)
        {
            if(str.charAt(i) == 'A')
            {
                arr[i] = 'X';
            }
            else if(str.charAt(i) == 'B')
            {
                arr[i] = 'Y';
            }
            else if(str.charAt(i) == 'C')
            {
                arr[i] = 'Z';

            }
            else{
                arr[i] = (char)(str.charAt(i) - 3);
            }

        }

        for(int i = 0 ; i < arr.length;i++)
        {
            bw.write(arr[i]);
        }

        bw.flush();
        bw.close();
    }
}

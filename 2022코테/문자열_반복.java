package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 문자열_반복 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        int testcase = Integer.parseInt(str);

        for(int t = 0; t < testcase;t++)
        {
            String s[] = br.readLine().split(" ");
            int R = Integer.parseInt(s[0]);
            str = s[1];

            ArrayList<Character> list = new ArrayList<>();
            for(int i = 0 ; i < str.length();i++)
            {
                for(int j = 0 ; j < R;j++)
                {
                    list.add(str.charAt(i));
                }
            }

            for(Character c : list)
            {
                bw.write(c);
            }
            bw.write("\n");
            bw.flush();
        }



    }
}

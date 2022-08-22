package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 전화번호_목록 {

    public static boolean check(String a,String b)
    {
        for(int i = 0 ; i < Math.min(a.length(),b.length()); i++)
        {
            if(a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();
        int testcase = Integer.parseInt(str);


        for(int t = 0 ; t < testcase ; t++)
        {
            str = br.readLine();
            int n = Integer.parseInt(str);
            String arr[] = new String[n];

            for(int i = 0 ; i < n ; i++)
            {
                str = br.readLine();
                arr[i] = str;
            }

            Arrays.sort(arr);
            boolean flag = true;

            for(int i = 0 ; i < n -1 ; i++)
            {

                if(check(arr[i],arr[i+1])){
                    flag = false;
                    break;
                }

            }



            if(flag) bw.write("YES\n");
            else bw.write("NO\n");

            bw.flush();

        }
        bw.close();
    }


}

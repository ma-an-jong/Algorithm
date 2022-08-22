package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
 */

public class 듣보잡 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        ArrayList<String> a = new ArrayList<>();
        String s;

        for(int i = 0 ; i < N + M ; i++){
            s = br.readLine();
            a.add(s);
        }


        Collections.sort(a);

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0 ; i < N + M -1 ; i++)
        {
            if(a.get(i).equals(a.get(i+1)))
            {
                ans.add(a.get(i));
            }
        }

        bw.write(a.size() + "\n");
        for(String answer : ans)
        {
            bw.write(answer + "\n");
        }
            bw.flush();
            bw.close();




    }
}

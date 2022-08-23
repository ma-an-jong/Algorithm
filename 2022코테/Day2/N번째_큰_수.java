package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class N번째_큰_수 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int N = Integer.parseInt(s);

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N; i++)
        {
            String str[] = br.readLine().split(" ");
            for(int j = 0 ; j < N;j++)
            {
                list.add(Integer.parseInt(str[j]));
            }
        }

        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list.get(N-1));



    }
}

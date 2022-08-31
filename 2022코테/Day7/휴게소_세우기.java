package Day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 휴게소_세우기 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int L = Integer.parseInt(str[2]);

        str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N;i++)
        {
            list.add(Integer.parseInt(str[i]));
        }










    }
}

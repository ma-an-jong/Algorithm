package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱_난쟁이 {

    static int select[] = new int[9];
    static int []arr = new int[9];
    static boolean flag = false;
    static List<Integer> ans = new ArrayList<>();

    static void comb(int N,int idx ,int count){
        if(flag) return;

        if(N == idx )
        {
            if(count == 7)
            {
                int sum = 0;

                for(int i = 0 ; i < 9; i++)
                {
                    if(select[i] == 1)
                        sum += arr[i];
                }

                if(sum == 100)
                {
                    for(int i = 0 ; i < 9;i++)
                    {
                        if(select[i] == 1)
                            ans.add(arr[i]);
                    }

                    Collections.sort(ans);

                    for(int a : ans)
                    {
                        System.out.println(a);
                    }

                    flag = true;

                }

            }
            return;
        }

        select[idx] = 0;
        comb(N,idx+1,count);
        select[idx] = 1;
        comb(N,idx+1,count+1);

    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < 9 ; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        comb(9,0,0);


    }
}

package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 완전제곱수 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = (int)Math.ceil(Math.sqrt(M))  ; i <= (int)Math.sqrt(N);i++)
        {
            list.add(i*i);
        }

        if(list.size() == 0) {
            System.out.println(-1);
            return;
        }


        int sum = 0;
        for(int a : list)
        {
            sum += a;
        }

        System.out.println(sum);
        System.out.println(list.get(0));

    }
}

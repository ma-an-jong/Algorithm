package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스_문제 {
    public static void main(String args[] ) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        Queue<Integer> q = new LinkedList<>();

        for(int i= 1; i <= N;i++)
        {
            q.add(i);
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty())
        {
            count++;

            int x = q.remove();

            if(count == K)
            {
                list.add(x);
                count = 0;
            }
            else
            {
                q.add(x);
            }

        }
        bw.write("<");

        for(int i = 0 ; i < list.size();i++)
        {
            if(i == list.size() - 1)
            {
                bw.write(list.get(i)+">");
            }
            else
            {
                bw.write(list.get(i) + ", ");
            }
        }

        bw.flush();



    }
}

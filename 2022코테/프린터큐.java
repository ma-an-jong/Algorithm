package Day1;

import java.io.*;
import java.util.*;

public class 프린터큐 {

    static class Pair{
        int value;
        int index;

        Pair(int index,int value)
        {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < testcase;t++) {

            String str[] = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Pair> q = new LinkedList<>();

            for(int i = 0 ; i < str.length;i++)
            {
                Pair p = new Pair(i,Integer.parseInt(str[i]));
                pq.add(Integer.parseInt(str[i]));
                q.add(p);
            }
            int count = 0;
            while(true)
            {
                Pair print = q.remove();
                int top = pq.peek();

                if(print.value >= top)
                {
                    count++;
                    if(print.index == M)
                    {
                        break;
                    }

                    pq.remove();

                }
                else
                {
                    q.add(print);
                }

            }

            bw.write(count+"\n");


        }
        bw.flush();
    }
}

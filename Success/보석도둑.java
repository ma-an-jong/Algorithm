package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class 보석도둑 {
    static class Item implements Comparable<Item> {
        int m;
        int v;
        Item(int m , int v)
        {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Item o) {
            return m == o.m ? o.v -v : m - o.m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Item[] items = new Item[N];
        int[] bags = new int[K];
        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");
            int m = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);

            items[i] = new Item(m,v);
        }

        for(int i = 0 ; i < K;i++)
        {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(items);
        Arrays.sort(bags);

        long ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0,cursor = 0 ; i < K;i++)
        {
            int size = bags[i];
            for(; cursor < N;cursor++)
            {
                if(items[cursor].m > size)
                {
                    break;
                }
                else
                {
                    pq.add(items[cursor].v);
                }
            }

            if(!pq.isEmpty())
            {
                ans += pq.remove();
            }


        }

        System.out.println(ans);
    }

}

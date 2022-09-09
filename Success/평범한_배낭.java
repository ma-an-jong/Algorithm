package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 평범한_배낭  {
    static class Item{
        int w;
        int v;

        Item(int w,int v)
        {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int knap[] = new int[K+1];
        ArrayList<Item> list = new ArrayList<>();

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            Item item = new Item(w,v);
            list.add(item);
        }

//        Collections.sort(list, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return o1.w - o2.w;
//            }
//        });

        for(int i = 0 ; i < list.size() ;i++)
        {
            Item item = list.get(i);
            for(int j = K ; j >= item.w ; j--)
            {
                knap[j] = Math.max(knap[j], knap[j - item.w] + item.v);
            }
        }

        System.out.println(knap[K]);

    }

}

package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 올림 {
    static class Node implements Comparable<Node>{
        int idx;
        int gold;
        int silver;
        int bronze;

        Node(int idx,int gold,int silver,int bronze)
        {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }


        @Override
        public int compareTo(Node o) {
            if(o.gold == this.gold)
            {
                if(o.silver == this.silver)
                {
                    return o.bronze - this.bronze;
                }

                return o.silver - this.silver;
            }

            return o.gold - this.gold;
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int V = Integer.parseInt(str[1]);

        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");
            int idx = Integer.parseInt(str[0]);
            int gold = Integer.parseInt(str[1]);
            int silver = Integer.parseInt(str[2]);
            int bronze = Integer.parseInt(str[3]);

            list.add(new Node(idx,gold,silver,bronze));
        }

        Collections.sort(list);

//        list.stream().forEach(v -> System.out.println(v.idx+" "+v.gold + " " + v.silver+ " " + v.bronze));

        int rank = 1;
        int tmp =0;
        Node now = list.get(0);
        for(int i = 1 ; i < list.size();i++)
        {
            if(now.idx == V)
            {
                System.out.println(rank);
                return;
            }

            Node node = list.get(i);

            if(node.gold == now.gold && now.silver == node.silver && now.bronze == node.bronze)
            {
                now = node;
                tmp++;
            }
            else
            {
                now = node;
                rank += tmp;
                tmp = 0;
                rank++;
            }
        }

        if(now.idx == V)
        {
            System.out.println(rank);
        }

    }
}

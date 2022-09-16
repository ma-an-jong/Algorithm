package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 순회강연 {
    static class Pair{
        int p;
        int d;
        Pair(int pay,int day)
        {
            p = pay;
            d = day;
        }
    }

    static int find(int[] arr,int a)
    {
        if(arr[a] != a)
        {
            arr[a] = find(arr,arr[a]);
        }
        return arr[a];
    }


    static void union(int[] arr , int a,int b)
    {
        int ap = find(arr,a);
        int bp = find(arr,b);

        arr[bp] = ap;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0 ; i <N;i++)
        {
            String str[] = br.readLine().split(" ");
            Pair p = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            list.add(p);
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.p == o2.p) return o1.d - o2.d;
                return o2.p - o1.p;
            }
        });
        int ans = 0;
        int[] arr = new int[100001];
        for(int i = 0 ; i < arr.length;i++)
        {
            arr[i] = i;
        }
        for(int i = 0 ; i < list.size();i++)
        {
            Pair pair = list.get(i);
            int a = find(arr,pair.d);
            if(a == 0) continue;
            union(arr,a-1,a);
            ans += pair.p;
        }
        System.out.println(ans);
    }
}




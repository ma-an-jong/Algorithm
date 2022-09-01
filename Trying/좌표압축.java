package Algorithm.Trying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 좌표압축 {

    static class Pair{
        int v;
        int idx;

        Pair(int v,int idx)
        {
            this.v = v;
            this.idx = idx;
        }

    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");

        HashSet<Integer> xset = new HashSet<>();

        for(int i = 0 ; i < n;i++)
        {
            int v = Integer.parseInt(str[i]);
            xset.add(v);
        }

        ArrayList<Integer> list = new ArrayList<>(xset);
        Collections.sort(list);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < list.size();i++)
        {
            map.put(list.get(i),i);
        }

        for(int i = 0 ; i < str.length;i++)
        {
            bw.write(map.get(Integer.parseInt(str[i]))+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 빈도_정렬{

    static class Pair implements Comparable<Pair>{
        int value;
        int count;

        Pair(int value,int count)
        {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }

    static void sort(Pair[] arr, int L,int R)
    {

        if(L == R) return;

        int mid = (L+R)/2;

        sort(arr,L,mid);
        sort(arr,mid+1,R);

        int left = L;
        int right = mid + 1;

        Pair[] tmp = new Pair[R-L+1];

        int cursor = 0;
        while(left <= mid && right <= R)
        {
            if(arr[left].count >= arr[right].count)
            {
                tmp[cursor++] = arr[left++];
            }
            else
            {
                tmp[cursor++] = arr[right++];
            }
        }

        while(left <= mid)
        {
            tmp[cursor++] = arr[left++];
        }

        while(right <= R)
        {
            tmp[cursor++] = arr[right++];
        }

        for(int i = L ; i <= R;i++)
        {
            arr[i] = tmp[i -L];
        }



    }


    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        List<Pair> list = new ArrayList<>();

        for(int i = 0 ; i < str.length;i++)
        {
            int v = Integer.parseInt(str[i]);
            boolean flag = true;

            for(int j = 0 ; j < list.size();j++)
            {
                Pair p = list.get(j);
                if(p.value == v)
                {
                    p.count++;
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                list.add(new Pair(v,1));
            }

        }

        Pair arr[] = new Pair[list.size()];

        for(int i = 0 ; i < arr.length;i++)
        {
            arr[i] = list.get(i);
        }

        //Arrays.stream(arr).forEach(v -> System.out.println(v.count + " " + v.value));

        sort(arr,0,arr.length-1);

        for(int i = 0 ; i < arr.length;i++)
        {
            for(int j = 0 ; j < arr[i].count; j++)
            {
                bw.write(arr[i].value + " ");
            }
        }

        bw.flush();



    }
}

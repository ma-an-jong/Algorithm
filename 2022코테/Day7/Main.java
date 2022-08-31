package Day7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int upperBound(List<Integer> list , int v)
    {
        int low,high;
        low = 0;
        high = list.size() - 1;

        while(low <= high)
        {
            int mid = (low+high)/2;
            if(list.get(mid) > v)
            {
                high = mid - 1;
            }
            else
            {
                low = mid +1;
            }
        }
        return low;
    }

    static int lowerBound(List<Integer> list , int v)
    {
        int low,high;
        low = 0;
        high = list.size() - 1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(list.get(mid) >= v)
            {
                high = mid - 1;
            }
            else
            {
                low = mid +1;
            }
        }
        return low;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n;i++)
        {
            list.add(Integer.parseInt(str[i]));
        }

        Collections.sort(list);
        int m = Integer.parseInt(br.readLine());

        str = br.readLine().split(" ");
        for(int i = 0 ; i < m ; i++)
        {

            int value = Integer.parseInt(str[i]);
            int low = 0;
            int high = list.size() - 1;

            int ans = 0;
            while(low <= high)
            {
                int mid = (low+high)/2;
                if(list.get(mid) > value)
                {
                    high = mid - 1;
                }
                else if (list.get(mid) < value)
                {
                    low = mid+1;
                }
                else {
                    ans = 1;
                    break;
                }
            }

            bw.write(ans+"\n");
        }
        bw.flush();
    }
}

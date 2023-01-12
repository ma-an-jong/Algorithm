package Day7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장긴증가하는부분수열5 {

    static int lowerBound(int arr[],int value)
    {
        int low = 0;
        int high = arr.length-1;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(arr[mid] >= value)
            {
                high = mid -1;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        int arr[] = new int[n];
        int memo[] = new int[n];
        Arrays.fill(memo,Integer.MAX_VALUE);
        List<Integer> ans[] = new ArrayList[n];

        for(int i = 0 ; i < n;i++)
        {
            ans[i] = new ArrayList<>();
        }

        int cursor = 0;
        for(int i = 0 ; i < n ;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
            int idx = lowerBound(memo,arr[i]);

            ans[idx].add(arr[i]);
            memo[idx] = arr[i];
        }

        int cnt = 0;
        for(int i = 0 ; i < memo.length;i++)
        {
            if(memo[i] != Integer.MAX_VALUE) cnt++;
        }

//        bw.write(cnt+"\n");
//
//        for(int i = 0 ; i < ans.size();i++)
//        {
//            bw.write(ans.get(i)+" ");
//        }

        bw.flush();
    }
}

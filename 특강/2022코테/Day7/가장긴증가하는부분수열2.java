package Day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장긴증가하는부분수열2 {

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

        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        int arr[] = new int[n];
        int memo[] = new int[n];
        Arrays.fill(memo,Integer.MAX_VALUE);

        for(int i = 0 ; i < n ;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
            int idx = lowerBound(memo,arr[i]);
            memo[idx] = arr[i];
        }

        int cnt = 0;
        for(int i = 0 ; i < memo.length;i++)
        {
            if(memo[i] != Integer.MAX_VALUE) cnt++;
        }

        System.out.println(cnt);
    }
}

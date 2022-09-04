package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전깃줄 {
    static int lowerbound(int arr[],int value)
    {
        int low = 0;
        int high =  arr.length-1;

        while(low <= high)
        {
            int mid = (low + high) /2;

            if(arr[mid] >= value)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[501];

        for(int i = 0 ; i < N;i++)
        {
            String str[] = br.readLine().split(" ");
            int idx = Integer.parseInt(str[0]);
            int value = Integer.parseInt(str[1]);
            arr[idx] = value;
        }

        int select[] = new int[501];
        Arrays.fill(select,Integer.MAX_VALUE);

        for(int i = 0 ; i < arr.length;i++)
        {
            if(arr[i] != 0)
            {
                int idx = lowerbound(select,arr[i]);
                select[idx] = arr[i];
            }
        }
        int count = 0;
        for(int i = 0 ; i < select.length;i++)
        {
            if(select[i] != Integer.MAX_VALUE)
            {
                count++;
            }
            else
            {
                break;
            }
        }

        System.out.println(N - count);

    }
}

package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 반도체_설계 {
    static int lowerbound(int arr[],int value)
    {
        int low = 0;
        int high = arr.length - 1;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[N];
        for(int i = 0; i < N ; i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }
        int select[] = new int[N];
        Arrays.fill(select,Integer.MAX_VALUE);
        for(int i = 0 ; i < N;i++)
        {
            int idx = lowerbound(select,arr[i]);
            select[idx] = arr[i];
        }
        int count = 0;
        for(int i = 0 ; i < N ; i++)
        {
            if(select[i]!=Integer.MAX_VALUE)
            {
                count ++;
            }
        }

        System.out.println(count);

    }
}

package Day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 누적합 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);

        int arr[] = new int[N+1];
        str = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++)
        {
            arr[i+1] = Integer.parseInt(str[i]);
        }

        for(int i = 1; i <=N;i++)
        {
            arr[i] = arr[i-1]+arr[i];
        }

        int left = 1;
        int right = 1;

        int ans = Integer.MAX_VALUE;

//        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));

        while(right <= N)
        {
            int sum = arr[right] - arr[left-1];
            int length = right - left + 1;

            if(sum >= S)
            {
                ans = Math.min(ans,length);
            }



            if(left == right) right++;
            else if(sum > S) left++;
            else right++;
        }

        if(ans == Integer.MAX_VALUE)
        {
            System.out.println(0);
        }
        else {
            System.out.println(ans);
        }

    }
}

package Day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 랜선_자르기 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int K = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        int arr[] = new int[K];

        long low = 0;
        long high = Integer.MAX_VALUE;

        for(int i = 0 ; i < K;i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long ans = 0;

        while(low<=high)
        {
            long mid = (low+high)/2;
            long cnt = 0;
            for(int i = 0 ; i < K;i++)
            {
                cnt += arr[i]/mid;
            }

            if(cnt >= N)
            {
                if(mid > ans)
                {
                    ans = mid;
                }
                low = mid+1;
            }
            else if (cnt < N)
            {
                high = mid-1;
            }

        }

        System.out.println(ans);



    }
}

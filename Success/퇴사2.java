package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 퇴사2 {
    static class Pair{
        int t;
        int p;
        Pair(int t,int p)
        {
            this.t = t;
            this.p = p;
        }
    }
    static int solve(Pair[] arr,int index)
    {
        if(index >= arr.length) return 0;
        Pair pair = arr[index];
        int notSelect = solve(arr,index+1);
        int select= (index+pair.t > arr.length) ? 0 : solve(arr,index+pair.t) + pair.p;
        return Math.max(notSelect,select);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N+1];
        for(int i = 0 ; i < N;i++)
        {
            String[] str = br.readLine().split(" ");
            arr[i] = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        int[] memo = new int[N+1];

        for(int i = N-1;i >= 0; i--)
        {
            if(i + arr[i].t > N)
            {
                memo[i] = memo[i+1];
            }
            else
            {
                memo[i] = Math.max(memo[i+1],memo[i+arr[i].t] + arr[i].p);
            }
        }

        System.out.println(memo[0]);



    }
}

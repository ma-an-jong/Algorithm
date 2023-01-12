package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 차트 {
    static void perm(int cnt)
    {
        if(cnt == N)
        {
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            int ans = 0;
            for(int i = 0 ; i < N;i++)
            {
                sum += select[i];
                list.add(sum);
            }
            for(int i = 0 ; i < list.size()-1;i++)
            {
                for(int j = i + 1; j< list.size();j++)
                {
                    if(list.get(i) + 50 == list.get(j))
                    {
                        ans+=1;
                    }
                }
            }

            result = Math.max(ans,result);

            return;
        }

        for(int i = 0 ; i < N;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                select[cnt] = arr[i];
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }
    static int N;
    static int arr[];
    static boolean visited[];
    static int select[];
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];
        select = new int[N];
        for(int i = 0 ; i < N;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        perm(0);
        System.out.println(result);




    }
}

package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 전구와_스위치 {
    static void toggle(char[] arr,int idx)
    {
        if(arr[idx] == '1')
        {
            arr[idx] = '0';
        }
        else
        {
            arr[idx] = '1';
        }
    }

    static void solve(int idx,int count) {
        if (idx == N)
        {
            if(src[idx - 1] != trg[idx - 1])
            {
                return;
            }

            ans = Math.min(count, ans);
            return;
        }

        if (src[idx-1] == trg[idx-1])
        {
            solve(idx + 1, count);
        }
        else
        {
            if(idx < N-1)
            {
                toggle(src,idx+1);
            }
            toggle(src,idx);
            toggle(src,idx-1);

            solve(idx+1,count+1);

            toggle(src,idx);
            toggle(src,idx-1);

            if(idx < N-1)
            {
                toggle(src,idx+1);
            }

        }
    }
    static int N;
    static char[] src;
    static char[] trg;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String source = br.readLine();
        String target = br.readLine();

        src = new char[N];
        trg = new char[N];
        char tmp[] = new char[N];
        for(int i = 0 ; i < N;i++)
        {
            src[i] = source.charAt(i);
            tmp[i] = source.charAt(i);
            trg[i] = target.charAt(i);
        }

        solve(1,0);

        for(int i = 0 ; i < N;i++)
        {
            src[i] = tmp[i];
        }

        toggle(src,0);toggle(src,1);
        solve(1,1);

        if(ans == Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }

    }
}

/*
7
1101000
1111111
*/

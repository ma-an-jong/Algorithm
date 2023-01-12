package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 뒤집힌_덧셈 {
    static int rev(int x)
    {
        Queue<Integer> q = new LinkedList<>();

        while(x != 0)
        {
            int v = x % 10;
            q.add(v);
            x /= 10;
        }

        int ans = 0;
        while(!q.isEmpty())
        {
            int v = q.remove();
            if(v == 0)
            {
                ans *= 10;
                continue;
            }
            ans *= 10;
            ans += v;
        }

        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
//        System.out.println(rev(a));
//        System.out.println(rev(b));
        int v = rev(a) + rev(b);

        System.out.println(rev(v));
    }
}

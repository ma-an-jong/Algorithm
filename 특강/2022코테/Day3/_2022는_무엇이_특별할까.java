package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _2022는_무엇이_특별할까 {
    static int a;
    static void perm(int N,int idx,String str)
    {
        if(N == idx)
        {
            if(str.charAt(0) != '0' )
            {
                try{
                    int b = Integer.parseInt(str);
                    if(b > a) list.add(str);
                }
                catch (Exception e)
                {

                }

            }

            return;
        }

        for(int i = 0; i < N;i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                perm(N,idx+1,str+i);
                visited[i] = 0;
            }
        }
    }

    static int visited[];
    static String s;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split( " ");

        int N = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);

        visited = new int[d];

        int value = N;
        int remain;

        Stack<Integer> stack = new Stack<>();

        while(value > 0)
        {
            remain = value % d;
            value = value / d;

            stack.push(remain);
        }

        s = "";

        while(!stack.isEmpty())
        {
            s += stack.pop();
        }

        try{
            a = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            System.out.println(-1);
            return;
        }

        perm(d,0,"");
        Collections.sort(list);

        //list.stream().forEach( v-> System.out.println(v));

        if(list.isEmpty())
        {
            System.out.println(-1);
            return;
        }

        String target = list.get(0);

        int ans = 0;

        for(int i = 0 ; i < target.length();i++)
        {
            ans *= d;
            ans += target.charAt(i) - '0';
        }

        System.out.println(ans);

    }

}

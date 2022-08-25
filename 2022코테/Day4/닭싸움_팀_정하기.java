package Day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 닭싸움_팀_정하기 {

    static int find(int[] arr, int a)
    {
        if(arr[a] == a)
        {
            return a;
        }

        int ap = find(arr,arr[a]);
        arr[a] = ap;
        return ap;
    }

    static void union(int[] arr, int a,int b)
    {
        int ap = find(arr,a);
        int bp = find(arr,b);
        if(ap != bp)
        {
            arr[ap] = bp;
        }

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int friends[] = new int[n+1];
        ArrayList<Integer> enemy[] = new ArrayList[n+1];

        for(int i = 0 ; i  <= n;i++)
        {
            friends[i] = i;
            enemy[i] = new ArrayList();
        }

        for(int i = 0 ; i < m ; i++)
        {
            String str[] = br.readLine().split(" ");

            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);

            if(str[0].equals("E"))
            {
                enemy[a].add(b);
                enemy[b].add(a);
            }
            else
            {
                union(friends,a,b);
            }
        }

        for(int i = 1 ; i < enemy.length;i++)
        {
            ArrayList<Integer> list = new ArrayList<>();

            for(int j = 0 ; j < enemy[i].size();j++)
            {
                int e = enemy[i].get(j);
                list.add(e);
            }

            for(int j = 0 ; j < list.size();j++)
            {
                int e = list.get(j); //i의 적
                for(int k = 0 ; k < enemy[e].size();k++) //적의 적 탐색
                {
                    int f = enemy[e].get(k); //적의 적을 구해서
                    union(friends,i,f); //친구
                }
            }
            
        }

        int ans = 0;

        for(int i = 1 ; i < friends.length;i++)
        {
            if(friends[i] == i)
            {
                ans++;
            }
        }

        System.out.println(ans);

    }
}

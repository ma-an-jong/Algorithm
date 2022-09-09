package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 앱 {
    static class App{
        int m;
        int c;

        App(int m , int c)
        {
            this.m = m;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        ArrayList<App> list = new ArrayList<>();

        str = br.readLine().split(" ");
        String ci[] = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++)
        {
            int m = Integer.parseInt(str[i]);
            int c = Integer.parseInt(ci[i]);
            App app = new App(m,c);
            list.add(app);
        }

        Collections.sort(list, new Comparator<App>() {
            @Override
            public int compare(App o1, App o2) {
                return o1.c - o2.c;
            }
        });

        int value = 100*100;
        int[] memory = new int[value+1];

        for(int i = 0 ; i < list.size();i++)
        {
            App app = list.get(i);
            for(int j = value;j >= app.c;j--)
            {
                memory[j] = Math.max(memory[j], memory[j - app.c] + app.m);
            }
        }
        for(int i = 0; i < memory.length;i++)
        {
            if(memory[i] >= M) {
                System.out.println(i);
                return;
            }
        }







    }
}

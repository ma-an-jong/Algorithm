package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _4연산 {

    interface Callback{
        long call(long s);
    }

    static List<Callback> callbacks = List.of(new Callback() {
        @Override
        public long call(long s) {
            return s+s;
        }
    },new Callback() {
        @Override
        public long call(long s) {
            return s*s;
        }
    });

    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        long s = Long.parseLong(str[0]);
        long t = Long.parseLong(str[1]);
        if(s==t) {
            System.out.println(0);
            return;
        }
        Queue<Long> q = new ArrayDeque<>();
        Queue<String> c = new ArrayDeque<>();
        q.add(s);
        c.add("");

        q.add(0L);
        c.add("-");

        q.add(1L);
        c.add("/");

        List<String> ans = new ArrayList<>();
        int cnt = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            long value = q.remove();
            String command = c.remove();

            if(value > t) continue;

            if(value == t) {
                ans.add(command);
                cnt = command.length();
            }

            if(command.length() > cnt) break;

            for (int i = 0; i < 2; i++) {
                long nextValue = callbacks.get(i).call(value);
                if(nextValue == 0 || nextValue == 1) continue;
                String nextCommand = command + (i==0?'+':'*');
                q.add(nextValue);
                c.add(nextCommand);
            }

        }
        if(ans.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(ans);
        System.out.println(ans.get(0));

    }
}

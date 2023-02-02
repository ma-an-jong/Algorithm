package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 이모티콘 {
    static int S;
    static int SIZE = 1001 * 2;
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> c = new ArrayDeque<>();
        Queue<Integer> cnt = new ArrayDeque<>();
        boolean[][] visited = new boolean[SIZE][SIZE];
        q.add(1);
        c.add(0);
        cnt.add(0);
        visited[1][0] = true;

        while(!q.isEmpty()) {

            int s = q.remove();
            int clip = c.remove();
            int count = cnt.remove();

            if(!visited[s][s]) {
                q.add(s);
                cnt.add(count+1);
                c.add(s);
                visited[s][s] = true;
            }

            if(s+clip < SIZE && !visited[s+clip][clip]) {
                if(s+clip == S) {
                    System.out.println(count+1);
                    return;
                }
                q.add(s+clip);
                c.add(clip);
                cnt.add(count+1);
                visited[s+clip][clip] = true;
            }

            if(s-1 >= 0 && !visited[s-1][clip]) {
                if(s-1 == S) {
                    System.out.println(count+1);
                    return;
                }
                q.add(s-1);
                cnt.add(count+1);
                c.add(clip);
                visited[s-1][clip] = true;
            }


        }

    }
}

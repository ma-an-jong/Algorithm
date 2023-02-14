package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 데스_나이트 {

    static int[] dy = {-2,-2,0,0,2,2};
    static int[] dx = {-1,1,-2,2,-1,1};
    static int N;
    static int r;
    static int c;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        boolean[][] visited = new boolean[N][N];
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        r = Integer.parseInt(str[2]);
        c = Integer.parseInt(str[3]);

        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();
        Queue<Integer> qc = new ArrayDeque<>();
        qx.add(b); qy.add(a); qc.add(0);
        visited[a][b] = true;

        while(!qx.isEmpty()) {

            int y = qy.remove();
            int x = qx.remove();
            int cost = qc.remove();

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(!visited[ny][nx]) {

                    if(ny == r && nx == c) {
                        System.out.println(cost+1);
                        return;
                    }

                    visited[ny][nx] = true;
                    qx.add(nx);
                    qy.add(ny);
                    qc.add(cost+1);
                }
            }

        }

        System.out.println(-1);

    }
}

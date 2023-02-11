package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 벽_부수고_이동하기 {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static int N;
    static int M;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int c;
        boolean flag;

        public Node(int x, int y, int c,boolean flag) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            return c-o.c;
        }
    }

    static int bfs(int i,int j){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(j,i,1,true));

        int[][][] visited = new int[N][M][2];

        for (int k = 0; k < N; k++) {
            for (int l = 0; l < M; l++) {
                Arrays.fill(visited[k][l],Integer.MAX_VALUE);
            }
        }

        visited[i][j][0] = 1;

        while(!q.isEmpty()) {

            Node node = q.remove();

            if(node.y == N-1 && node.x == M-1) return node.c;
            if(node.c > ans) continue;

            for (int k = 0; k < 4; k++) {
                int ny = node.y + dy[k];
                int nx = node.x + dx[k];

                if(check(ny,nx)) continue;

                if(map[ny][nx] == 1){
                    if(node.flag) {
                        if(visited[ny][nx][1] > node.c + 1) {
                            visited[ny][nx][1] = node.c + 1;
                            q.add(new Node(nx,ny,node.c+1,false));
                        }
                    }
                } else {
                    if(node.flag){
                        if(visited[ny][nx][0] > node.c + 1) {
                            visited[ny][nx][0] = node.c + 1;
                            q.add(new Node(nx,ny,node.c+1,true));
                        }
                    }
                    else {
                        if(visited[ny][nx][1] > node.c + 1) {
                            visited[ny][nx][1] = node.c + 1;
                            q.add(new Node(nx,ny,node.c+1,false));
                        }
                    }

                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static boolean check(int y,int x){
        if(y < 0 || y >= N || x < 0 || x>= M) return true;
        return false;
    }

    static boolean count(int i,int j) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if(check(y,x)) continue;

            if(map[y][x] == 0) cnt++;
         }

        if(cnt <= 1) return false;

        return true;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ans = Math.min(bfs(0,0),ans);

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }


    }
}

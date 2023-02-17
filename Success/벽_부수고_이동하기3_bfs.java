package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 벽_부수고_이동하기3_bfs {

    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static int[][][] dp;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int k;
        int cost;
        boolean morning;

        public Node(int y, int x, int k, int cost, boolean morning) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.cost = cost;
            this.morning = morning;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }

    }

    static boolean check(int y,int x){
        return y < 0 || x < 0 || y >= N || x >= M;
    }
    static void bfs() {

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,0,1,true));

        while(!q.isEmpty()) {

            Node node = q.remove();

            if(node.y == N-1 &&  node.x == M-1) {
                ans = Math.min(ans,node.cost);
                continue;
            }

            if(node.cost > ans) continue;

            for (int i = 0; i < 4; i++) {
                int y = node.y + dy[i];
                int x = node.x + dx[i];

                if(check(y,x)) continue;

                if(arr[y][x] == 1) {
                    if(node.k == K) continue;
                    if(node.morning) {
                        if(dp[y][x][node.k+1] > node.cost + 1) {
                            dp[y][x][node.k+1] = node.cost + 1;
                            q.add(new Node(y,x,node.k+1,node.cost+1,false));
                        }
                    }
                    else {
                        if(dp[y][x][node.k+1] > node.cost + 2) {
                            dp[y][x][node.k+1] = node.cost + 2;
                            q.add(new Node(y,x,node.k+1,node.cost+2,false));
                        }
                    }
                }
                else {
                    if(dp[y][x][node.k] > node.cost + 1) {
                        dp[y][x][node.k] = node.cost + 1;
                        q.add(new Node(y,x,node.k,node.cost+1,!node.morning));
                    }
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        arr = new int[N][M];
        dp = new int[N][M][K+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }


        bfs();

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }



    }
}

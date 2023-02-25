package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 레이저_통신 {
    static int H;
    static int W;
    static char[][] arr;
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int cost;
        int dir;

        public Node(int y, int x, int cost, int dir) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        W = Integer.parseInt(str[0]);
        H = Integer.parseInt(str[1]);

        arr = new char[H][W];

        Queue<Node> q = new PriorityQueue<>();
        int[][][] visited  = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(visited[i][j],Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'C') {
                    if(q.isEmpty()) {
                        q.add(new Node(i,j,-1,-1));
                        for (int k = 0; k < 4; k++) {
                            visited[i][j][k] = -1;
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()){

            Node node = q.remove();

            for (int i = 0; i < 4; i++) {

                int y = node.y + dy[i];
                int x = node.x + dx[i];

                if(y < 0 || x < 0 || y >= H || x >= W) continue;
                int nextCost = node.dir == i ? node.cost : node.cost + 1;
                if(visited[y][x][i] <= nextCost) continue;

                visited[y][x][i] = nextCost;

                if(arr[y][x] == '.'){
                    q.add(new Node(y,x,nextCost,i));
                }else if (arr[y][x] == 'C') {
                    ans = Math.min(ans,nextCost);
                }
            }
        }

        System.out.println(ans);

    }
}

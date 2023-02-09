package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 구슬_탈출2 {

    static int[] dy = {1,0,-1,0};

    static int[] dx = {0,1,0,-1};
    static int[] goal = new int[2];
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][][][] visited;

    static class Node implements Comparable<Node> {
        int[] red;
        int[]  blue;
        int cnt;
        int direction;
        public Node(int[] red, int[] blue, int cnt, int direction) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }

    static boolean isGoal(int[] pos) {
        return pos[0] == goal[0] && pos[1] == goal[1];
    }

    //DRUL
    static boolean isRedFirst(int[] red,int[] blue,int direction) {
        if(direction == 0) {
            return red[0] > blue[0];
        }
        else if(direction == 1) {
            return red[1] > blue[1];
        }
        else if(direction == 2){
            return red[0] < blue[0];
        }
        else if(direction == 3) {
            return red[1] < blue[1];
        }
        else throw new RuntimeException();
    }

    static int[] next(int[] pos,int[] anotherPos, int direction){
        if(isGoal(pos)) return new int[] {pos[0],pos[1]};

        int y = pos[0];
        int x = pos[1];

        while(true){
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            if(arr[ny][nx] == 'O') return new int[]{ny,nx};
            if(arr[ny][nx] == '#') break;
            if((ny == anotherPos[0] && nx == anotherPos[1])) break;

            y = ny;
            x= nx;
        }

        return new int[]{y,x};
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new char[N][M];
        visited = new boolean[N][M][N][M];

        int[] red = new int[2];
        int[] blue =  new int[2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);

                if(arr[i][j] == 'R') {
                    red[0] = i; red[1] = j;
                }
                else if(arr[i][j] == 'B') {
                    blue[0] = i; blue[1] = j;
                }
                else if(arr[i][j] == 'O') {
                    goal[0] = i; goal[1] = j;
                }
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(red,blue,0,-1));
        while (!q.isEmpty()) {

            Node node = q.remove();
            visited[node.red[0]][node.red[1]][node.blue[0]][node.blue[1]] = true;

            if(node.cnt > 10) {
                System.out.println(-1);
                return;
            }

            boolean redGoal = isGoal(node.red);
            boolean blueGoal = isGoal(node.blue);

            if(blueGoal) {
                continue;
            }

            if(redGoal) {
                System.out.println(node.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {

                if(i == node.direction) continue;

                int[] nextRed;
                int[] nextBlue;

                if(isRedFirst(node.red,node.blue,i)) {
                    nextRed = next(node.red,node.blue,i);
                    nextBlue = next(node.blue,nextRed,i);
                }
                else {
                    nextBlue = next(node.blue,node.red,i);
                    nextRed = next(node.red,nextBlue,i);
                }


                if(visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) continue;

                q.add(new Node(nextRed,nextBlue,node.cnt+1,i));
            }

        }

        System.out.println(-1);

    }
}

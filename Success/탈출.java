package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 탈출 {
    static int[] dx  ={0,1,0,-1};
    static int[] dy =  {1,0,-1,0};
    static int R;
    static int C;
    static char[][] arr;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    static Queue<Node> water(Queue<Node> q) {

        Queue<Node> tmp = new ArrayDeque<>();

        while (!q.isEmpty()) {

            Node node = q.remove();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

                if(arr[ny][nx] == '.' || arr[ny][nx] == 'S') {
                    arr[ny][nx] = '*';
                    tmp.add(new Node(ny,nx));
                }
            }
        }

        return tmp;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        arr = new char[R][C];
        int[] s = new int[2];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'S') {
                    s[0] = i; s[1] = j;
                }
            }
        }

        boolean[][] visited = new boolean[R][C];
        visited[s[0]][s[1]] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(s[0],s[1]));

        Queue<Node> water = new ArrayDeque<>();

        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if(arr[j][k] == '*') {
                    water.add(new Node(j,k));
                }
            }
        }

        for (int i = 1; i <= R*C; i++) {

            water = water(water);

            Queue<Node> tmp = new ArrayDeque<>();
            while (!q.isEmpty()) {

                Node node = q.remove();

                for (int j = 0; j < 4; j++) {
                    int ny = node.y + dy[j];
                    int nx = node.x + dx[j];

                    if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

                    if(arr[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        tmp.add(new Node(ny,nx));
                    } else if(arr[ny][nx] == 'D'){
                        System.out.println(i);
                        return;
                    }
                }
            }

            q = tmp;
        }

        System.out.println("KAKTUS");
    }
}

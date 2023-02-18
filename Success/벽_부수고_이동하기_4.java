package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 벽_부수고_이동하기_4 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int[] set;
    static int[] value;

    static class Node {
        int y;
        int x;
        int c;

        public Node(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }

    static int find(int a) {

        if(set[a] == a) {
            return a;
        }

        set[a] = find(set[a]);
        return set[a];
    }

    static void union(int a, int b) {

        int ap = find(a);
        int bp = find(b);

        if(ap != bp) {
            set[ap] = bp;
        }

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];

        set = new int[N*M];
        for (int i = 0; i < N*M; i++) {
            set[i] = i;
        }

        value = new int[N*M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    Queue<Node> q = new ArrayDeque<>();

                    q.add(new Node(i,j,1));
                    visited[i][j] = true;
                    int cnt = 0;

                    while(!q.isEmpty()) {

                        Node node = q.remove();
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int ny = node.y + dy[k];
                            int nx = node.x + dx[k];

                            if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                            if(!visited[ny][nx] && arr[ny][nx] == 0) {
                                visited[ny][nx] = true;
                                union(ny*M + nx,i*M + j);
                                q.add(new Node(ny,nx,node.c+1));
                            }

                        }

                    }

                    int parent = find(i*M + j);
                    value[parent] = cnt;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    int count = 1;
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if(y < 0 || x < 0 || y >= N || x >= M) continue;
                        if(arr[y][x] == 0) {
                            int parent = find(y*M + x);
                            if(!list.contains(parent)) {
                                list.add(parent);
                                count += value[parent];
                            }
                        }
                    }

                    bw.write(String.valueOf(count % 10));
                }
                else {
                    bw.write("0");
                }
            }
            bw.write("\n");
        }

        bw.flush();



    }
}

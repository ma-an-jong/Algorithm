package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 다리_만들기 {
    static int N;
    static int[][] arr;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void fill(){
        Queue<Integer> qy = new ArrayDeque<>();
        Queue<Integer> qx = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        int index = 0;

        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                if(arr[k][l] == 1 && !visited[k][l]){
                    qx.add(l);
                    qy.add(k);
                    index += 1;
                    arr[k][l] = index;
                    visited[k][l] = true;
                    while(!qx.isEmpty()) {

                        int y = qy.remove();
                        int x = qx.remove();

                        for (int m = 0; m < 4; m++) {
                            int nx = x + dx[m];
                            int ny = y + dy[m];
                            if(nx < 0 || nx>= N || ny < 0 || ny >= N) continue;

                            if(!visited[ny][nx] && arr[ny][nx] != 0) {
                                qy.add(ny);
                                qx.add(nx);
                                visited[ny][nx] = true;
                                arr[ny][nx] = index;
                            }
                        }

                    }
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            arr[i] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        }

        fill();
        int ans = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(arr[i][j] != 0 ) {
                    boolean[][] visited = new boolean[N][N];
                    Queue<Integer> qx = new ArrayDeque<>();
                    Queue<Integer> qy = new ArrayDeque<>();
                    Queue<Integer> c = new ArrayDeque<>();

                    qx.add(j);
                    qy.add(i);
                    c.add(0);
                    visited[i][j] = true;

                    while(!qx.isEmpty()) {
                        int x = qx.remove();
                        int y = qy.remove();
                        int cost = c.remove();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || nx>= N || ny < 0 || ny >= N) continue;

                            if(!visited[ny][nx] && arr[ny][nx] == 0) {
                                visited[ny][nx] = true;
                                qx.add(nx);
                                qy.add(ny);
                                c.add(cost+1);
                            }

                            if(arr[ny][nx] != 0 && arr[ny][nx] != arr[i][j]) {
                                ans = Math.min(cost,ans);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);





    }
}

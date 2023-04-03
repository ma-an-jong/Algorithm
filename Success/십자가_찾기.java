package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 십자가_찾기 {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    static boolean foo(int y,int x,int length) {

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= length; j++) {
                int ny = y+j*dy[i];
                int nx = x+j*dx[i];

                if(ny < 0 || nx < 0 || nx >= M || ny >= N) return false;
                if(arr[ny][nx] != '*')
                    return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= length; j++) {
                int ny = y+j*dy[i];
                int nx = x+j*dx[i];

                visited[ny][nx] = true;
            }
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == '*') {
                    for (int k = 1; k <= (Math.min(N,M) / 2) + 1; k++) {
                        if(foo(i,j,k)){
                            cnt++;
                            sb.append((i+1) + " " + (j+1) + " " + k + "\n");
                            visited[i][j] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == '*' && !visited[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());


    }
}

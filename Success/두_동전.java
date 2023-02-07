package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두_동전 {
    static int N;
    static int M;
    static char[][] arr;
    static int[][][][] visited;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean out(int y,int x){
        return y < 0 || y >= N || x < 0 || x >= M;
    }
    static int valid(int ay,int ax, int by,int bx) {
        boolean aOut = out(ay,ax);
        boolean bOut = out(by,bx);

        if(aOut && bOut) return 2;
        if((aOut && !bOut) || (!aOut && bOut)) return 0;
        return 1;
    }
    static void foo(int[][] pos,int cnt) {

        if(cnt > ans || cnt > 10) {
            return;
        }

        int now = valid(pos[0][0],pos[0][1],pos[1][0],pos[1][1]);

        if(now == 0) {
            ans = Math.min(ans,cnt);
            return;
        }
        else if(now == 2){
            return;
        }

        if(visited[pos[0][0]][pos[0][1]][pos[1][0]][pos[1][1]] <= cnt) return;

        visited[pos[0][0]][pos[0][1]][pos[1][0]][pos[1][1]] = cnt;

        for (int i = 0; i < 4; i++) {
            int[][] tmp = new int[2][2];

            for (int j = 0; j < 2; j++) {
                int ny = pos[j][0] + dy[i];
                int nx = pos[j][1] + dx[i];
                if(out(ny,nx) || arr[ny][nx] != '#') {
                    tmp[j][0] = ny; tmp[j][1] = nx;
                }
                else {
                    tmp[j][0] = pos[j][0]; tmp[j][1] = pos[j][1];
                }
            }

            foo(tmp,cnt+1);
        }


    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new char[N][M];
        visited = new int[N][M][N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    Arrays.fill(visited[i][j][k],Integer.MAX_VALUE);
                }
            }
        }
        int cursor = 0;
        int[][] pos = new int[2][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] =  line.charAt(j);
                if(arr[i][j] == 'o') {
                    pos[cursor][0] = i;
                    pos[cursor++][1] = j;
                }
            }
        }
        foo(pos,0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }
}

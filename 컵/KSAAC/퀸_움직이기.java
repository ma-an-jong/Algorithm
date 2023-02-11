package Algorithm.컵.KSAAC;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 퀸_움직이기 {

    static int N;
    static int M;
    static int K;
    static char[][] map;

    static int[] dy = {-1,1,0,0,-1,-1,1,1};
    static int[] dx = {0,0,-1,1,-1,1,-1,1};

    static int dir(int[] s ,int[] e) {
        if(e[0] < s[0] && e[1] == s[1]) return 0;
        if(e[0] > s[0] && e[1] == s[1]) return 1;
        if(e[0] == s[0] && e[1] < s[1]) return 2;
        if(e[0] == s[0] && e[1] > s[1]) return 3;
        int dy = e[0] - s[0];
        int dx = e[1] - s[1];

        if(e[0] < s[0] && e[1] < s[1] && dx == dy) return 4;
        if(e[0] < s[0] && e[1] > s[1] && dx == Math.abs(dy)) return 5;
        if(e[0] > s[0] && e[1] < s[1] && Math.abs(dx) == dy) return 6;
        if(e[0] > s[0] && e[1] > s[1] && dx == dy) return 7;

        return -1;
    }

    static boolean check(int[] p){
        if(p[0] < 0 || p[0] >= N || p[1] < 0 || p[1] >= M) return false;

        return true;
    }

    static boolean go(int[] s ,int[] e) {
        int dir = dir(s,e);
        if(dir == -1) return false;
        int[] p = new int[]{s[0] + dy[dir], s[1] + dx[dir]};
        while(check(p)) {
            if(map[p[0]][p[1]] == '#') return false;
            if(p[0] == e[0] && p[1] == e[1]) return true;

            p[0] += dy[dir];
            p[1] += dx[dir];
        }


        return false;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        map = new char[N][M];

        for (int i = 0; i <N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s[0]--; s[1]--;

        int[] e = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        e[0]--; e[1]--;


        if(K == 1) {
            if(go(s,e)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
            return;
        }

        int[][][] visited = new int[N][M][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i == s[0] && j == s[1]) continue;
                if(go(s,new int[]{i,j})) {
                    visited[i][j][0]++;
                }
            }
        }


        for (int i = 1; i < K; i++) {

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(visited[j][k][i-1] > 0) {
                        int[] a = new int[]{j,k};

                        for (int l = 0; l < N; l++) {
                            for (int m = 0; m < M; m++) {
                                if(l == j && k == m) continue;
                                int[] b = new int[]{l,m};
                                if(go(a,b)) {
                                    visited[l][m][i] += visited[j][k][i-1];
                                }

                            }
                        }

                    }
                }
            }
        }

        System.out.println(visited[e[0]][e[1]][K-1]);
    }
}

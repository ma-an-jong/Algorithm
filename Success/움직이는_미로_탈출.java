package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 움직이는_미로_탈출 {
    static int[] dx = {0,1,0,-1,1,-1,1,-1,0};
    static int[] dy = {1,0,-1,0,1,-1,-1,1,0};

    static List<char[][]> list = new ArrayList<>();

    static class Nxde {
        int y;
        int x;
        int cnt;

        public Nxde(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[8][8];
        char[][] tmp = new char[8][8];
        int level = 8;
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
                tmp[i][j] = map[i][j];
                if(map[i][j] == '#') level = Math.min(level,i);
            }
        }

        level = 8-level;

        list.add(tmp);
        for (int i = 0; i <= level; i++) {
            char[][] next = new char[8][8];

            for (int j = 0; j < 8; j++) {
                Arrays.fill(next[j],'.');
            }

            for (int row = 7; row > 0; row--) {
                for (int col = 0; col < 8; col++) {
                    next[row][col] = tmp[row-1][col];
                }
            }

            list.add(next);
            tmp = next;
        }


        Queue<Nxde> q = new LinkedList<>();
        q.add(new Nxde(7,0,0));

        while (!q.isEmpty()) {
            Nxde nxde = q.remove();

            if(list.size() <= nxde.cnt) {
                System.out.println(1);
                return;
            }

            char[][] maze = list.get(nxde.cnt);

            if(maze[nxde.y][nxde.x] == '#') continue;

            if(nxde.y == 0 && nxde.x == 7) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                if(i == dx.length-1) {
                    nxde.cnt++;
                    q.add(nxde);
                    continue;
                }

                int ny = nxde.y + dy[i];
                int nx = nxde.x + dx[i];

                if(ny < 0 || nx < 0 || nx >= 8 || ny >= 8) continue;

                if(maze[ny][nx] != '#') {
                    q.add(new Nxde(ny,nx, nxde.cnt + 1));
                }
            }

        }


        System.out.println(0);

    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Two_Dots {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N;
    static int M;

    static char[][] arr;
    static boolean flag = false;


    static void dfs(int x, int y,boolean[][] visited,int startX,int startY,int count){

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

            if(!visited[ny][nx] && arr[startY][startX] == arr[ny][nx]){
                visited[ny][nx] = true;
                dfs(nx,ny,visited,startX,startY,count + 1);
            }

            if((startX == nx) && (startY == ny) && count >= 4 && arr[startY][startX] == arr[y][x]) {
                flag = true;
            }
        }


    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(flag) continue;
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                dfs(j,i,visited,j,i,1);
            }
        }

        if(flag) System.out.println("Yes");
        else System.out.println("No");





    }
}

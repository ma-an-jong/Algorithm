package Algorithm.컵.아니메;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gorani_Command {

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        boolean[][] map = new boolean[N+1][M+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i],true);
        }

        for (int i = 1; i < N; i++) {
            int distance = Integer.parseInt(br.readLine());

            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    int away = Math.abs(i-row) + Math.abs(1-col);
                    if(away != distance) map[row][col] = false;
                }
            }
        }

        str = br.readLine().split(" ");

        for (int i = 1; i <= M; i++) {
            int distance = Integer.parseInt(str[i-1]);

            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    int away = Math.abs(N-row) + Math.abs(i-col);
                    if(away != distance) map[row][col] = false;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i][j]){
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}

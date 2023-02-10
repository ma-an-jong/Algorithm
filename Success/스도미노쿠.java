package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;

public class 스도미노쿠 {

    static int N;
    static int[][] arr = new int[9][9];
    static boolean[][] visited;
    static int testCase = 0;
    static boolean flag;

    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static BufferedWriter bw;

    static boolean valid(int i,int j,int x){

        int row = (i / 3)*3;
        int col = (j / 3)*3;

        for (int k = row; k < row + 3; k++) {
            for (int l = col; l < col + 3; l++) {
                if(arr[k][l] == x) return false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if(arr[k][j] == x) return false;
            if(arr[i][k] == x) return false;
        }

        return true;
    }

    static void foo(int i,int j) throws Exception {
        if(flag) return;
        if(i == 8 && j == 9) {
            bw.write("Puzzle " + testCase + "\n");
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    bw.write(arr[k][l]+"");
                }
                bw.write("\n");
            }
            flag = true;
            return;
        }

        if(j == 9) {
            i++;
            j=0;
        }

        if(arr[i][j] != 0) foo(i,j+1);
        else {
            for (int k = 0; k < 2; k++) {
                int ni = i + dy[k];
                int nj = j + dx[k];
                if(ni >= 9 || ni < 0 || nj < 0 || nj >= 9) continue;

                if(arr[ni][nj] != 0) continue;
                for (int l = 1; l <= 9; l++) {
                    for (int m = 1; m <= 9; m++) {
                        if(l == m || visited[l][m]) continue;
                        if(valid(i,j,l) && valid(ni,nj,m)) {
                            visited[l][m] = true; visited[m][l] = true;
                            arr[i][j] = l; arr[ni][nj] = m;
                            foo(i,j+1);
                            visited[l][m] = false; visited[m][l] = false;
                            arr[i][j] = 0; arr[ni][nj] = 0;
                        }
                    }
                }

            }
        }

    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            testCase++;
            flag = false;
            arr = new int[9][9];
            visited = new boolean[10][10];
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            String[] str;
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    int v = Integer.parseInt(str[j*2]);
                    String s = str[j*2 +1];
                    int row = s.charAt(0) - 'A';
                    int col = s.charAt(1) - '1';
                    arr[row][col] = v;
                }

                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[2]);
                visited[a][b] = true; visited[b][a] = true;
            }

            str = br.readLine().split(" ");

            for (int i = 0; i < 9; i++) {
                String s = str[i];
                int row = s.charAt(0) - 'A';
                int col = s.charAt(1) - '1';

                arr[row][col] = i+1;
            }

            foo(0,0);

        }

        bw.flush();







    }
}

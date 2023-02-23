package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 행렬 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ans;

    static void swap(int a,int b , int y,int x){
        for (int i = a; i <= y; i++) {
            for (int j = b; j <= x; j++) {
                map[i][j] = map[i][j] == 0 ? 1: 0;
            }
        }
    }

    static boolean check(){
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                flag &= map[i][j] == ans[i][j];
            }
        }

        return flag;
    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                ans[i][j] = line.charAt(j) - '0';
            }
        }



        int cnt = 0;

        if(check()) {
            System.out.println(cnt);
            return;
        }

        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if(map[i][j] != ans[i][j]){
                    swap(i,j,i+2,j+2);
                    cnt++;

                    boolean flag = true;
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            flag &= map[k][l] == ans[k][l];
                        }
                    }

                    if(flag) {
                        System.out.println(cnt);
                        return;
                    }
                }

            }
        }


        System.out.println(-1);

    }
}

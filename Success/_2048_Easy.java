package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2048_Easy {
    static int N;
    static int[][] arr;
    static int max = 2;
    static class Board{

        int[][] map;

        Board(int[][] map){
            this.map = new int[N][N];
            for (int i = 0; i < N; i++) {
                this.map[i] = Arrays.copyOf(map[i],N);
            }
        }

        int max() {
            int x = 0;
            for (int i = 0; i < N; i++) {
                x = Math.max(x,Arrays.stream(map[i]).max().getAsInt());
            }

            return x;
        }

        void up() {
            int[][] tmp = new int[N][N];

            for (int i = 0; i < N; i++) {
                tmp[0][i] = map[0][i];
            }

            for (int j = 0; j < N; j++) {
                int cursor = 0;
                for (int i = 1; i < N; i++) {
                    if(map[i][j] == 0) continue;
                    if(tmp[cursor][j] == 0){
                        tmp[cursor][j] = map[i][j];
                    }else if(tmp[cursor][j] == map[i][j]) {
                        tmp[cursor][j] += map[i][j];
                        cursor++;
                    } else {
                        tmp[++cursor][j] = map[i][j];
                    }
                }
            }

            this.map = tmp;
        }

        void down() {
            int[][] tmp = new int[N][N];

            for (int i = 0; i < N; i++) {
                tmp[N-1][i] = map[N-1][i];
            }

            for (int j = 0; j < N; j++) {
                int cursor = N-1;
                for (int i = N-2; i >= 0; i--) {
                    if(map[i][j] == 0) continue;
                    if(tmp[cursor][j] == 0){
                        tmp[cursor][j] = map[i][j];
                    }else if(tmp[cursor][j] == map[i][j]) {
                        tmp[cursor][j] += map[i][j];
                        cursor--;
                    } else {
                        tmp[--cursor][j] = map[i][j];
                    }
                }
            }

            this.map = tmp;
        }

        void left() {
            int[][] tmp = new int[N][N];

            for (int i = 0; i < N; i++) {
                tmp[i][0] = map[i][0];
            }

            for (int j = 0; j < N; j++) {
                int cursor = 0;
                for (int i = 1; i < N; i++) {
                    if(map[j][i] == 0) continue;
                    if(tmp[j][cursor] == 0){
                        tmp[j][cursor] = map[j][i];
                    }else if(tmp[j][cursor] == map[j][i]) {
                        tmp[j][cursor] += map[j][i];
                        cursor++;
                    } else {
                        tmp[j][++cursor] = map[j][i];
                    }
                }
            }

            this.map = tmp;
        }

        void right() {
            int[][] tmp = new int[N][N];

            for (int i = 0; i < N; i++) {
                tmp[i][N-1] = map[i][N-1];
            }

            for (int j = 0; j < N; j++) {
                int cursor = N-1;

                for (int i = N-2; i >= 0; i--) {
                    if(map[j][i] == 0) continue;
                    if(tmp[j][cursor] == 0){
                        tmp[j][cursor] = map[j][i];
                    }else if(tmp[j][cursor] == map[j][i]) {
                        tmp[j][cursor] += map[j][i];
                        cursor--;
                    } else {
                        tmp[j][--cursor] = map[j][i];
                    }
                }
            }

            this.map = tmp;
        }
    }

    static void perm(int cnt,int[] select) {
        if(cnt == 5) {
            Board board = new Board(arr);
            for (int i = 0; i < 5; i++) {
                foo(board,select[i]);
            }

            max = Math.max(board.max(),max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            select[cnt] = i;
            perm(cnt+1,select);
        }

    }

    static void foo(Board board,int d) {
        if(d == 0) {
            board.up();
        } else if(d == 1) {
            board.left();
        } else if(d == 2) {
            board.down();
        } else if(d == 3) {
            board.right();
        } else throw new RuntimeException();
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(str[j]);
                arr[i][j] = x;

            }
        }

        perm(0,new int[5]);
        System.out.println(max);
//        Board board = new Board(arr);
//
//        board.left();
//
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board.map[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}

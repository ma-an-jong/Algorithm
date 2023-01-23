package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class 테트로미노 {

    static int[][][] blue = {{{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}}};
    static int[][][] yellow = {{{0,0},{0,1},{1,0},{1,1}}};
    static int[][][] orange = {
             {{0,0},{0,1},{-1,1},{-2,1}}
            ,{{0,0},{-1,0},{-2,0},{0,1}}
            ,{{0,0},{0,1},{1,1},{2,1}}
            ,{{0,0},{0,1},{1,0},{2,0}}
            ,{{0,0},{0,1},{0,2},{1,0}}
            ,{{0,0},{0,1},{0,2},{1,2}}
            ,{{0,0},{0,1},{0,2},{-1,2}}
            ,{{0,0},{1,0},{1,1},{1,2}}
    };
    static int[][][] green = {{{0,0},{1,0},{1,1},{2,1}}
        ,{{0,0},{0,1},{-1,1},{1,0}}
        ,{{0,0},{0,1},{-1,1},{-1,2}}
        ,{{0,0},{0,1},{1,1},{1,2}}
    };
    static int[][][] pink = {{{0,0},{1,0},{2,0},{1,1}}
        ,{{0,0},{0,1},{1,1},{-1,1}}
        ,{{0,0},{0,1},{0,2},{-1,1}}
        ,{{0,0},{0,1},{0,2},{1,1}}
    };

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[][][]> list = List.of(blue,yellow,green,orange,pink);

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }


        int ans = Integer.MIN_VALUE;


        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int i = 0; i < 5; i++) {
                    int[][][] arr = list.get(i);
                    for (int s = 0; s <arr.length ; s++)
                    {
                        int sum = 0;
                        boolean flag = true;
                        for (int j = 0; j < arr[s].length; j++) {
                            int nx = arr[s][j][1] + x;
                            int ny = arr[s][j][0] + y;

                            if(nx >= M || nx < 0 || ny >= N || ny < 0){
                                flag = false;
                                break;
                            };
                            sum+= map[ny][nx];
                        }

                        if(flag) ans = Math.max(ans,sum);
                    }
                }
            }
        }

        System.out.println(ans);

    }
}

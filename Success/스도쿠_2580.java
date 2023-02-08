package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 스도쿠_2580 {

    static int[][] arr = new int[9][9];
    static List<int[]> list = new ArrayList<>();
    static boolean flag = true;
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
    static void foo(int i) throws Exception{

        if(i == list.size()) {

            for (int r = 0; r < 9; r ++) {
                for (int c = 0; c < 9; c++) {
                    bw.write(arr[r][c] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            flag = false;
            return;
        }

        int[] pos = list.get(i);
        for (int j = 1; j <= 9; j++) {
            if(flag && valid(pos[0],pos[1],j)) {
                arr[pos[0]][pos[1]] = j;
                foo(i+1);
                arr[pos[0]][pos[1]] = 0;
            }
        }


    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j] == 0) {
                    list.add(new int[]{i,j});
                }
            }
        }


        foo(0);


    }
}

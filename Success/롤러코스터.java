package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 롤러코스터 {
    static int R;
    static int C;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        if(R % 2 == 1) {

            for (int i = 0; i < R; i++) {
                if(i % 2 == 0) {
                    for (int j = 0; j < C-1; j++) {
                        bw.write("R");
                    }
                } else {
                    for (int j = 0; j < C-1; j++) {
                        bw.write("L");
                    }
                }
                if(i != R-1) bw.write("D");
            }
        } else if(C % 2 == 1) {
            for (int i = 0; i < C; i++) {
                if(i % 2 == 0) {
                    for (int j = 0; j < R-1; j++) {
                        bw.write("D");
                    }
                } else {
                    for (int j = 0; j < R-1; j++) {
                        bw.write("U");
                    }
                }

                if(i != C-1) bw.write("R");
            }
        } else {
            int y = 1;
            int x = 0;
            int min = arr[1][0];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if((i + j) % 2 == 0) continue;

                    if(min > arr[i][j]){
                        min = arr[i][j];
                        y = i;
                        x = j;
                    }
                }
            }


            int[] s = {0,0};
            int[] d = {R-1,C-1};

            StringBuilder head = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            for (; s[0]+2 <= y; s[0]+=2) {
                for (int i = 0; i < C-1; i++) {
                    head.append("R");
                }
                head.append("D");
                for (int i = 0; i < C-1; i++) {
                    head.append("L");
                }
                head.append("D");
            }

            for (; d[0]-2 >= y; d[0]-=2) {
                tail.append("D");
                for (int i = 0; i < C-1; i++) {
                    tail.append("L");
                }
                tail.append("D");
                for (int i = 0; i < C-1; i++) {
                    tail.append("R");
                }
            }

            for (; s[1] + 2 <= x; s[1]+=2) {
                head.append("DRUR");
            }

            for (; d[1]-2 >= x; d[1]-=2) {
                tail = new StringBuilder("RURD" + tail.toString());
            }

            if(s[0] == y && s[1] < x) bw.write(head.toString() + "DR" + tail.toString());
            else bw.write(head.toString() + "RD" + tail.toString());
        }



        bw.flush();

    }
}

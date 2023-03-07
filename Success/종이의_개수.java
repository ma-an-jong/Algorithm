package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 종이의_개수 {

    static int N;
    static int arr[][];
    static int cnt[];

    static boolean check(int x, int y, int nx,int ny) {

        for (int i = y; i <= ny; i++) {
            for (int j = x; j <= nx; j++) {
                if(arr[i][j] != arr[y][x]) return false;
            }
        }

        return true;
    }

    static void count(int value) {
        cnt[value + 1] ++;
    }


    static void divide(int x, int y, int nx,int ny) {
        int length = nx - x+1;
        if(x < 0 || y < 0 || nx >= N || ny >= N) return;
        if(check(x,y,nx,ny)) {
            count(arr[y][x]);
        } else {
            int size = length/3;
            //System.out.println(size);
            for(int i = y; i <= ny; i+=size) {
                for (int j = x; j <= nx; j+=size) {
                    //System.out.println("i,j = " +i + "," +j + " : " + (i+size-1) + " ," + (j+size-1));
                    divide(j,i,j+size-1,i+size-1);
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            arr[i] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
         }

        cnt = new int[3];

        divide(0,0,N-1,N-1);

        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }

    }
}

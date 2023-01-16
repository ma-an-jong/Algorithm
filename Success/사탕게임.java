package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 사탕게임 {

    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static char[] color = {'C','P','Z','Y'};
    static int N;
    static char[][] arr;

    static void swap(int x,int y, int a , int b){
        char tmp = arr[y][x];
        arr[y][x] = arr[b][a];
        arr[b][a] = tmp;
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int ans = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >=N || ny >= N) continue;
                    if(arr[y][x] == arr[ny][nx]) continue;

                    swap(x,y,nx,ny);

                    int max = 0;
                    for (int j = 0; j < N; j++) {
                        int[] count = new int[4];

                        for (int k = 0; k < 4; k++) {
                            int cnt = 0;
                            for (int l = 0; l < N; l++) {
                                if(arr[j][l] == color[k]){
                                    cnt++;
                                    count[k] = Math.max(cnt,count[k]);
                                }
                                else {
                                    cnt = 0;
                                }
                            }
                        }
                        ans = Math.max(Arrays.stream(count).max().getAsInt(),ans);
                    }

                    for (int j = 0; j < N; j++) {
                        int[] count = new int[4];
                        for (int k = 0; k < 4; k++) {
                            int cnt = 0;
                            for (int l = 0; l < N; l++) {
                                if(arr[l][j] == color[k]){
                                    cnt++;
                                    count[k] = Math.max(cnt,count[k]);
                                }
                                else {
                                    cnt = 0;
                                }
                            }
                        }
                        ans = Math.max(Arrays.stream(count).max().getAsInt(),ans);
                    }

                    swap(x,y,nx,ny);
                }
            }
        }
        System.out.println(ans);

    }
}

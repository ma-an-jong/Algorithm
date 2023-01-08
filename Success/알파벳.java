package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 알파벳 {
    static int R;
    static int C;
    static char[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int foo(int x,int y,boolean[] alphabet,int count){
        int ans = count;
        for (int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;

            if(!alphabet[arr[ny][nx] - 'A']){
                boolean[] copyAlphabet = new boolean[26];

                for (int i = 0; i < 26; i++) {
                    copyAlphabet[i] = alphabet[i];
                }
                copyAlphabet[arr[ny][nx] - 'A'] = true;
                ans = Math.max(ans, foo(nx,ny,copyAlphabet,count+1));
                copyAlphabet[arr[ny][nx] - 'A'] = false;
            }

        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        int[][] dp = new int[R][C];
        boolean[] alphabet = new boolean[26];
        dp[0][0] = 1;
        alphabet[arr[0][0] -'A'] = true;
        System.out.println(foo(0,0,alphabet,1));
    }
}

package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 스타트와_링크 {

    static int N;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static int[] startTeam;
    static int[] linkTeam;

    static void foo(int startIndex,int linkIndex,int start,int link) {

        int n = startIndex + linkIndex;

        if(n == N) {
            ans = Math.min(ans, Math.abs(start - link));
            return;
        }

        if(startIndex < N/2) {
            int tmp = 0;
            for (int i = 0; i < startIndex; i++) {
                tmp += arr[startTeam[i]][n];
                tmp += arr[n][startTeam[i]];
            }

            startTeam[startIndex] = n;
            foo(startIndex+1,linkIndex,start+tmp,link);
        }

        if (linkIndex < N/2) {
            int tmp = 0;
            for (int i = 0; i < linkIndex; i++) {
                tmp += arr[linkTeam[i]][n];
                tmp += arr[n][linkTeam[i]];
            }
            linkTeam[linkIndex] = n;
            foo(startIndex,linkIndex+1,start,link+tmp);
        }

    }
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        startTeam = new int[N/2];
        linkTeam = new int[N/2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        foo(0,0,0,0);
        System.out.println(ans);
    }
}

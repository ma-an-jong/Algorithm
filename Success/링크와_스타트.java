package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 링크와_스타트 {
    static int N;
    static int[][] arr;
    static int[] start;
    static int[] link;
    static int ans = Integer.MAX_VALUE;
    static void foo(int startIndex,int linkIndex,int a,int b) {
        int n = startIndex + linkIndex;

        if(n == N) {
            if(startIndex == 0 || linkIndex == 0) return;
            ans = Math.min(ans, Math.abs(a-b));
            return;
        }

        int startValue = 0;
        int linkValue = 0;
        for (int i = 0; i < startIndex; i++) {
            startValue += arr[start[i]][n];
            startValue += arr[n][start[i]];
        }

        for (int i = 0; i < linkIndex; i++) {
            linkValue += arr[link[i]][n];
            linkValue += arr[n][link[i]];
        }
        start[startIndex] = n;
        foo(startIndex + 1,linkIndex,a + startValue,b);
        link[linkIndex] = n;
        foo(startIndex,linkIndex + 1,a,b + linkValue);

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        start = new int[N];
        link = new int[N];
        foo(0,0,0,0);
        System.out.println(ans);
    }
}

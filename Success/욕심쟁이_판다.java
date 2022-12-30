package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 욕심쟁이_판다 {

    static class Position implements Comparable<Position>{
        int x;
        int y;
        int v;

        Position(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }


        @Override
        public int compareTo(Position o) {
            return v- o.v;
        }


    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    public static void main(String[] args) throws Exception {
        Stub.stub();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        List<Position> list = new ArrayList<>();

        for(int i = 0 ; i < n;i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int v =Integer.parseInt(str[j]);
                arr[i][j] = v;
                list.add(new Position(j,i,v));
            }
        }

        Collections.sort(list);

        for(int i = 0 ; i < list.size();i++){
            Position p = list.get(i);

            for(int k = 0;k<4;k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                try{
                    if(arr[ny][nx] > arr[p.y][p.x]){
                        dp[ny][nx] = Math.max(dp[p.y][p.x] +1,dp[ny][nx]);
                    }

                }
                catch (Exception e){
                    continue;
                }
            }
        }

        long ans = Long.MIN_VALUE;

        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < n ;j++){
                ans = Math.max(ans,dp[i][j]);
            }
        }

        System.out.println(ans+1);

    }
}

package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 파일_합치기 {

    static int foo(int[][] cost, int[] arr,int i,int j){

        if(i == j) {
            return 0;
        }

        if(cost[i][j] != Integer.MAX_VALUE){
            return cost[i][j];
        }

        int sum = 0;
        for(int k = i; k <= j;k++){
            sum += arr[k];
        }

        for(int k = i; k < j;k++){
            cost[i][j] = Math.min(foo(cost,arr,i,k) + foo(cost,arr,k+1,j) + sum, cost[i][j]);
        }

        return cost[i][j];
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int T = 0 ; T < t ; T++){
            int n = Integer.parseInt(br.readLine());

            int[][] cost = new int[n+1][n+1];
            int[] arr = new int[n+1];

            String[] str = br.readLine().split(" ");

            for(int i = 0 ; i < n ;i++){
                arr[i+1] = Integer.parseInt(str[i]);
            }

            for(int i = 0 ; i < n+1;i++){
                Arrays.fill(cost[i],Integer.MAX_VALUE);
            }

            bw.write(foo(cost,arr,1,n)+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}





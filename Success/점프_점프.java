package Algorithm.Success;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 점프_점프 {

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n+1];
        int[] jump = new int[n+1];

        for(int i = 0; i < jump.length;i++){
            jump[i] = 10000;
        }

        for(int i = 1; i < n+1;i++){
            arr[i] = Integer.parseInt(str[i-1]);
        }
        jump[1] = 0;
        for(int i = 1 ; i < n+1;i++){
            for(int j = i+1; j < n+1; j++){
                if(arr[i] + i < j) continue;

                jump[j] = Math.min(jump[j],jump[i] + 1);
            }
        }
        if(jump[n] == 10000){
            System.out.println(-1);
        }
        else{
            System.out.println(jump[n]);
        }


    }
}

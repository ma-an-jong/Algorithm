package Algorithm.Trying;

import Algorithm.Stub;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ거리 {

    static int INIT = 1001*1001;


    static char foo(char c){

        switch (c){
            case 'B': return 'O';
            case 'O': return 'J';
            case 'J': return 'B';
        }

        return '\u0000';
    }
    
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        int[] dp = new int[n+1];

        Arrays.fill(dp,INIT);

        dp[1] = 0;

        for(int i = 1; i <= n;i++){
            char c = str.charAt(i-1);
            for(int j = i + 1; j <= n ; j++){

                char next = str.charAt(j-1);

                if(next != foo(c)) continue;

                dp[j] = Math.min(dp[j] , dp[i] + (j-i)*(j-i));
            }
        }


        if(dp[n] == INIT){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[n]);
        }



    }
}

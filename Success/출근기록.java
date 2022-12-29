package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 출근기록 {


    static boolean foo(boolean[][][][][] dp,int a,int b,int c,int p1, int p2){
        if(a > A || b > B || c > C) return false;

        if(a == A && b == B && c== C){
            StringBuilder sb=  new StringBuilder();
            for(int i = 1 ; i <= a+b+c;i++){
                sb.append(ans[i]);
            }
            System.out.println(sb.toString());
            return true;
        }

        if(dp[a][b][c][p1][p2]) return false;

        dp[a][b][c][p1][p2] = true;
        ans[a+b+c+1] = "A";
        if(foo(dp,a+1,b,c,0,p1)) return true;
        if(p1 != 1){
            ans[a+b+c+1] = "B";
            if(foo(dp,a,b+1,c,1,p1)) return true;
        }

        if(p1 != 2 && p2 != 2){
            ans[a+b+c+1] = "C";
            if(foo(dp,a,b,c+1,2,p1)) return true;
        }


        return false;
    }

    static int A=0;
    static int B=0;
    static int C=0;
    static int L;
    static String[] ans;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        L = str.length();
        ans = new String[L+1];
        for(int i = 0 ; i < str.length();i++){
            if(str.charAt(i) == 'A'){
                A++;
            }
            else if(str.charAt(i) == 'B'){
                B++;
            }
            else{
                C++;
            }
        }

        boolean[][][][][] dp = new boolean[A+1][B+1][C+1][3][3];

        if(!foo(dp,0,0,0,0,0)){
            System.out.println(-1);
        }

    }
}

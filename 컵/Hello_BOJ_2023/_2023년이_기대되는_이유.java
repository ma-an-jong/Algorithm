package Algorithm.컵.Hello_BOJ_2023;

import Algorithm.Stub;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _2023년이_기대되는_이유 {

    static Set<Integer> ans;
    static boolean foo(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0 && arr[i] != 1) return false;
        }

        return true;
    }

    static void fill(int[] arr,int n,int a,String s){
        if(n < 0) {
            ans.add(a);
            return;
        }
        int x = a-Integer.parseInt(s) + Integer.parseInt(arr[n] + s);
        int y = a+arr[n];
        fill(arr,n-1,y, String.valueOf(arr[n]));
        fill(arr,n-1,x,arr[n] + s);

    }

    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseSize = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCaseSize; testCase++) {
            String s = br.readLine();
            int n = Integer.parseInt(s);
            int[] arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0';
            }

            if(foo(arr)) {
                bw.write("Hello, BOJ 2023!\n");
                continue;
            }

             ans = new HashSet<>();
            ans.add(n);
            fill(arr,arr.length-2,arr[arr.length-1],String.valueOf(arr[arr.length-1]));

            int sum = 0;
            int cnt = 0;
            int m = 1;
            while(sum <= n) {
                sum = 0;

                for (int i = 0; i < arr.length; i++) {
                    sum += Math.pow(arr[i],m);
                }

                if(ans.contains(sum)) {
                    //System.out.println(sum+"/"+m);
                    cnt++;
                }
                m++;

            }

            bw.write(cnt+"\n");
        }
        bw.flush();

    }
}

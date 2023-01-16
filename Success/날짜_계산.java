package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 날짜_계산 {


    static int[] bound = {15,28,19};


    static boolean foo(int[] arr,int[] ans) {
        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            flag = flag&&(arr[i] == ans[i]);
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int e = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);

        int[] ans = {e,s,m};
        int[] arr = {1,1,1};

        int cnt = 1;

        while(true) {

            if(foo(arr,ans)) {
                System.out.println(cnt);
                return;
            }

            for (int i = 0; i < 3; i++) {
                arr[i]++;
            }
            cnt++;

            for (int i = 0; i < 3; i++) {
                if(arr[i] > bound[i]) {
                    arr[i] = 1;
                }
            }
        }

    }
}

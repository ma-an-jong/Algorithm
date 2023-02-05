package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 연산자_끼워넣기 {
    static int N;
    static int[] arr;
    static int[] count;

    interface Callback{
        int func(int x,int y);
    }

    static List<Callback> funcs = List.of(new Callback() {
        @Override
        public int func(int x, int y) {
            return x + y;
        }
    }, new Callback() {
        @Override
        public int func(int x, int y) {
            if(x < 0) {
                return - (Math.abs(x) / y);
            }
            return x - y;
        }
    }, new Callback() {
        @Override
        public int func(int x, int y) {
            return x * y;
        }
    }, new Callback() {
        @Override
        public int func(int x, int y) {
            return x/y;
        }
    });

    static void foo(int i , int[] cnt,int acc) {


        if(i == N) {
            max = Math.max(acc,max);
            min = Math.min(acc,min);
            return;
        }


        int[] next = new int[4];
        for (int j = 0; j < 4; j++) {
            next[j] = cnt[j];
        }

        for (int j = 0; j < 4; j++) {
            if(next[j] > 0){
                next[j]--;
                foo(i+1,next,funcs.get(j).func(acc,arr[i]));
                next[j]++;
            }
        }

    }
    static int max;
    static int min;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        count = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        foo(1,count,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }
}

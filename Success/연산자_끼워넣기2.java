package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 연산자_끼워넣기2 {
    interface Callback {
        int func(int x,int y);
    }
    static int N;
    static int[] arr;
    static int[] op;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Callback> list = List.of(new Callback() {
        @Override
        public int func(int x, int y) {
            return x + y;
        }
    } ,new Callback() {
        @Override
        public int func(int x, int y) {
            return x - y;
        }
    } ,new Callback() {
        @Override
        public int func(int x, int y) {
            return x * y;
        }
    } ,new Callback() {
        @Override
        public int func(int x, int y) {
            if(x < 0) {
                return - (Math.abs(x) / y);
            }
            return x / y;
        }
    });

    static void foo(int i, int sum,int[] operator) {
        if(i == N) {
            max = Math.max(sum,max);
            min = Math.min(sum,min);
            return;
        }

        int[] tmp = new int[4];
        for (int j = 0; j < 4; j++) {
            tmp[j] = operator[j];
        }

        for (int j = 0; j < 4 ; j++) {
            if(operator[j] > 0){
                tmp[j]--;
                foo(i+1,list.get(j).func(sum,arr[i]),tmp);
                tmp[j]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        foo(1,arr[0],op);

        System.out.println(max);
        System.out.println(min);
    }
}

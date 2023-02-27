package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 수_묶기 {
    static int N;
    static PriorityQueue<Integer> lessThanZero;
    static PriorityQueue<Integer> biggerThanZero;

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lessThanZero = new PriorityQueue<>();
        biggerThanZero = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x <= 0) lessThanZero.add(x);
            else biggerThanZero.add(x);
        }

        int sum = 0;

        while (!lessThanZero.isEmpty()) {
            int x = lessThanZero.remove();

            if(x == 0) break;

            if (!lessThanZero.isEmpty()) {
                int y = lessThanZero.remove();
                sum += x*y;
            } else {
                sum += x;
            }

        }

        while (!biggerThanZero.isEmpty()) {
            int x = biggerThanZero.remove();

            if(x == 1) {
                sum += x;
                continue;
            }

            if (!biggerThanZero.isEmpty()) {
                int y = biggerThanZero.remove();
                if(y == 1) {
                    sum += x;
                    sum += y;
                    continue;
                }
                sum += x*y;
            } else {
                sum += x;
            }

        }

        System.out.println(sum);

    }
}

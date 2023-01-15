package Algorithm.컵.Hello_BOJ_2023;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class 청소 {

    static class Node implements Comparable<Node> {

        int index;
        int value;

        Node(int index,int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - value;
        }
    }
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N-K; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j = i; j < i+K; j++) {
                pq.add(new Node(j,arr[j]));
            }

            int move = 0;
            Node now = pq.remove();
            while (!pq.isEmpty()){
                move += Math.abs(now.index - pq.peek().index);
                now = pq.remove();
            }
            ans = Math.min(move,ans);
        }

        System.out.println(ans);
    }
}

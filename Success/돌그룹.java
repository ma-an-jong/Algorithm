package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 돌그룹 {

    static int mean;

    static class Node implements Comparable<Node> {
        int a;
        int b;
        int c;

        public Node(int[] abc) {
            this.a = abc[0];
            this.b = abc[1];
            this.c = abc[2];
        }

        public boolean check() {
            return a == mean && b == mean && c == mean ;
        }

        public int gap() {
            int sum = 0;

            sum += Math.abs(a - mean);
            sum += Math.abs(b - mean);
            sum += Math.abs(c - mean);

            return sum;
        }

        public int[] copy() {
            return new int[]{a,b,c};
        }

        @Override
        public int compareTo(Node o) {
            return gap() - o.gap();
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arr).sum();
        if(sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        mean = sum / 3;
        Queue<Node> q = new PriorityQueue<Node>();
        boolean[][] visited = new boolean[1501][1501];

        Node n = new Node(arr);
        q.add(n);
        visited[n.a][n.b] = true;
        while (!q.isEmpty()) {
            Node node = q.remove();

            if(node.check()) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;

                    int[] tmp = node.copy();

                    if(tmp[i] > tmp[j]) {
                        tmp[i] -= tmp[j];
                        tmp[j] *= 2;
                    }
                    else {
                        tmp[j] -= tmp[i];
                        tmp[i] *= 2;
                    }

                    Node next = new Node(tmp);
                    if(visited[next.a][next.b]) continue;
                    visited[next.a][next.b] = true;
                    q.add(next);
                }
            }
        }

        System.out.println(0);

    }
}

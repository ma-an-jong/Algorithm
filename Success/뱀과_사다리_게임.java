package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 뱀과_사다리_게임 {
    static int N;
    static int M;
    static int[] arr = new int[101];

    static class Node implements Comparable<Node> {

        int index;
        int cnt;

        public Node(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        for (int i = 0; i <N + M; i++) {
            str = br.readLine().split(" ");
            arr[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1,0));
        boolean[] visited = new boolean[101];

        while(!pq.isEmpty()) {
            Node node = pq.remove();
            visited[node.index] = true;
            if(node.index == 100) {
                System.out.println(node.cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = node.index+ i;
                if(next > 100) continue;
                if(arr[next] != 0){
                    next = arr[next];
                }
                if(!visited[next]) {
                    pq.add(new Node(next,node.cnt+1));
                }

            }

        }
    }
}

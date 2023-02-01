package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 숨바꼭질4 {
    static int N;
    static int K;
    static int SIZE = 100_001*2;

    static class Node {
        int v;
        int cost;

        Node(int v,int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        if(N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }
        boolean[] visited = new boolean[SIZE];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(N,0));
        visited[N] = true;
        int[] before = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            before[i] = i;
        }
        int ans = Integer.MAX_VALUE;

        boolean flag = true;
        while(!q.isEmpty() && flag) {

            Node v = q.remove();
            List<Integer> next = List.of(v.v -1, v.v+1 , v.v*2);

            for (int o : next) {

                if(o < 0 || o >= SIZE) continue;

                if(!visited[o]) {
                    visited[o] = true;
                    before[o] = v.v;

                    if(o == K) {
                        ans = v.cost+1;
                        flag = false;
                        break;
                    }

                    Node adjv = new Node(o,v.cost + 1);
                    q.add(adjv);
                }
            }
        }

        bw.write(ans+"\n");

        int tmp = K;
        List<Integer> list = new ArrayList<>();
        list.add(K);
        while(before[tmp] != N){
            list.add(before[tmp]);
            tmp = before[tmp];
        }
        list.add(N);

        for (int i = list.size()-1; i >= 0 ; i--) {
            bw.write(list.get(i) +" ");
        }
        bw.flush();















    }
}

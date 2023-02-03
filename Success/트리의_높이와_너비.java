package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 트리의_높이와_너비 {
    static int N;
    static Node[] node;
    static int cnt = 0;
    static int[] d;
    static int ans = 1;
    static int dpt = 1;
    static class Node {
        Node left;
        Node right;
        int index;
        public Node(int index) {
            this.index = index;
        }

        void lvr(int depth){

            if(left != null) left.lvr(depth + 1);
            cnt++;

            if(d[depth] == 0) d[depth] = cnt;

            int distance = cnt - d[depth] + 1;
            if(distance == ans) {
                dpt = Math.min(dpt,depth);
            }
            else if(distance > ans){
                ans = distance;
                dpt = depth;
            }

            if(right != null) right.lvr(depth + 1);
        }
    }
    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        node = new Node[N+1];
        d = new int[N+1];

        for (int i = 0; i <= N; i++) {
            node[i] = new Node(i);
        }
        int root = 1;
        boolean[] flag = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int parent = Integer.parseInt(str[0]);
            int left = Integer.parseInt(str[1]);
            int right = Integer.parseInt(str[2]);
            if(left != -1) {
                node[parent].left = node[left];
                flag[left] = true;
            }
            if(right != -1) {
                node[parent].right = node[right];
                flag[right] = true;
            }
        }
        for (int i = 1; i < flag.length; i++) {
            if(!flag[i]) {
                root = i;
            }
        }

            cnt = 0;
            Arrays.fill(d,0);
            node[root].lvr(1);


        System.out.println(dpt + " " + ans);

    }
}

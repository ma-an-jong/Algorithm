package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 두_스티커 {

    static int H;
    static int W;
    static int N;

    static List<Node> nodes = new ArrayList<>();
    static boolean[][] arr;

    static int max = 0;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }


    static int[] select = new int[2];

    static boolean attach(Node a, Node b) {

        // 그대로 ㅏ
        if(a.r + b.r <= W && Math.max(a.c,b.c) <= H){
            return true;
        }

        //그대로 ㅜ
        if(Math.max(a.r,b.r) <= W && (a.c+b.c) <= H){
            return true;
        }

        //왼쪽 돌려서 ㅏ
        if(a.c + b.r <= W && Math.max(a.r,b.c) <= H){
            return true;
        }

        //왼쪽 돌려서 ㅜ
        if(Math.max(a.c, b.r) <= W && a.r + b.c <= H){
            return true;
        }

        //둘다 돌려서 ㅏ
        if(a.c + b.c <= W && Math.max(a.r,b.r) <= H){
            return true;
        }

        //둘다 돌려서 ㅜ
        if(Math.max(a.c , b.c) <= W && a.r + b.r <= H){
            return true;
        }

        //오른쪽 돌려서 ㅏ
        if(a.r + b.c <= W && Math.max(a.c,b.r) <= H){
            return true;
        }

        //오른쪽 돌려서 ㅜ
        if(Math.max(a.r, b.c) <= W && a.c + b.r <= H){
            return true;
        }


        return false;
    }
    static void foo(int n,int before) {
        if(n == 2){

            Node a = nodes.get(select[0]);
            Node b = nodes.get(select[1]);

            if(attach(a,b)) {
                int sum = a.r*a.c + b.r*b.c;
                max = Math.max(sum,max);
            }
            return;
        }


        for (int i = 0; i < nodes.size(); i++) {

            if(i != before) {
                select[n] = i;
                foo(n+1,i);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        H = Integer.parseInt(str[0]);
        W = Integer.parseInt(str[1]);
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            nodes.add(new Node(r,c));
        }

        foo(0,-1);
        System.out.println(max);




    }
}

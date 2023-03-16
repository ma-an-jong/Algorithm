package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class 트리의_순회 {
    static int N;
    static int[] in;
    static int[] post;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void foo(int inLeft,int inRight,int postLeft,int postRight) {

        if(inLeft == inRight) {
            sb.append(in[inLeft] + " ");
            return;
        }

        if(postRight < 0 || postLeft > postRight) return;


        int target = post[postRight];

        for (int i = inLeft; i <= inRight; i++) {
            if(target == in[i]){
                sb.append(target + " ");
                int len = i - inLeft;
                if(i > 0) foo(inLeft,i-1,postLeft,postLeft+len-1);
                foo(i+1,inRight,postLeft+len,postRight-1);
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        in = new int[N]; post = new int[N]; visited = new boolean[N+1];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(str[i]);
        }

        foo(0,N-1,0,N-1);
        System.out.println(sb.toString().trim());

    }
}

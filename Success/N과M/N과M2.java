package Algorithm.N과M;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M2 {
    static boolean[] visited;
    static BufferedWriter bw;
    static int N;
    static int M;

    static void foo(int i,int before,String s) throws Exception {
        if(i == M){
            bw.write(s.trim()+"\n");
            return;
        }


        for (int j = before+1; j <= N; j++) {
            if(!visited[j]){
                visited[j] = true;
                foo(i+1,j,s + " " +j);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visited = new boolean[N+1];
        foo(0,0,"");
        bw.flush();
    }
}

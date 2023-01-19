package Algorithm.N과M;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class N과M10 {
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[] arr;
    static int[] select;
    static boolean[] visited;
    static LinkedHashSet<List<Integer>> set;
    static void foo(int i,int before, int cnt) {
        if(cnt == M){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                list.add(select[j]);
            }
            set.add(list);
            return;
        }

        if(i == N) return;

        for (int j = 0; j < N; j++) {
            if(!visited[j] && before <= arr[j]){
                select[cnt] = arr[j];
                visited[j] = true;
                foo(i+1,arr[j],cnt+1);
                visited[j] =false;
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
        select = new int[M];
        visited = new boolean[N+1];
        set = new LinkedHashSet<>();
        str = br.readLine().split(" ");
        arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        foo(0,0,0);
        StringBuilder sb = new StringBuilder();
        set.forEach(v-> {
            v.forEach(a -> sb.append(a+" "));
            sb.append("\n");
        } );
        bw.write(sb.toString());
        bw.flush();
    }
}

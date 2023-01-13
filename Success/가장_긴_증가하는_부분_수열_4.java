package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장_긴_증가하는_부분_수열_4 {
    static int N;

    static int lowerbound(int[] seq,int v) {
        int start = 0;
        int last = seq.length - 1;

        while(start <= last) {
            int mid = (start + last) / 2;
            if(seq[mid] >= v){
                last = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] seq = new int[N];
        int[] arr = new int[N+1];
        List<Integer>[] list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(seq,Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(str[i]);
            arr[i] = v;
            int index = lowerbound(seq,v);
            seq[index] = v;
            list[index].add(i);
        }

        arr[N] = Integer.MAX_VALUE;
        int nowIndex = N;
        List<Integer> tmp = new ArrayList<>();
        for (int i = N-1; i >= 0 ; i--) {
            for (int j = 0; j < list[i].size(); j++) {
                int index = list[i].get(j);
                if(index < nowIndex && arr[index] < arr[nowIndex]) {
                    tmp.add(arr[index]);
                    nowIndex = index;
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(seq[i] != Integer.MAX_VALUE) ans++;
        }

        bw.write(ans +"\n");
        for (int i = tmp.size() -1 ; i >= 0; i--) {
            bw.write(tmp.get(i) + " ");
        }

        bw.flush();
    }
}

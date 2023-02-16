package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 가르침 {
    static int N;
    static int K;
    static int ans = 0;
    static List<String> words = new ArrayList<>();

    static void perm(int i ,int cnt ,int[] visited){
        if(i == 26){
            if(cnt == K) {
                int count = 0;
                for (String word : words) {
                    boolean flag = true;
                    for (int j = 0; j < word.length(); j++) {
                        char c = word.charAt(j);
                        flag &= visited[c-'a'] == 1;
                    }

                    if(flag) {
                        count++;
                    }
                }

                ans = Math.max(ans,count);
            }
            return;
        }
        int[] tmp = Arrays.copyOf(visited,26);

        if(tmp[i] == 0) {
            perm(i+1,cnt,tmp);
        }

        tmp[i] = 1;
        perm(i+1,cnt+1,tmp);
        tmp[i] = 0;

    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        if(K < 5) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words.add(s.substring(4,s.length()-4));
        }

        List<Character> list = List.of('a','c','t','i','n');
        int[] arr = new int[26];

        for (int i = 0; i < list.size(); i++) {
            arr[list.get(i) - 'a']= 1;
        }

        perm(0,0,arr);

        System.out.println(ans);

    }
}

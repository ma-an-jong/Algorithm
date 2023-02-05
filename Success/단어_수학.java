package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단어_수학 {
    static int N;
    static List<String> words;
    static Map<Character,Integer> map;
    static int[] select;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    static void foo(int i){
        if(i == map.size()) {
            int ans = 0;
//            for (int j = 0; j < map.size(); j++) {
//                System.out.print(select[j] + " ");
//            }
//            System.out.println();

            for (int j = 0; j < words.size(); j++) {
                int tmp = 0;
                String word = words.get(j);
                for (int k = 0; k < word.length(); k++) {
                    Integer index = map.get(word.charAt(k));
                    tmp *= 10;
                    tmp += select[index];
                }
                ans += tmp;
            }
            max = Math.max(max,ans);
            return;
        }


        for (int j = 0; j <= 9; j++) {
            if(!visited[j]) {
                visited[j] = true;
                select[i] = j;
                foo(i+1);
                visited[j] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j),map.size());
                }
            }
            words.add(s);
        }

        select = new int[map.size()];
        visited = new boolean[10];

        foo(0);
        System.out.println(max);

    }
}

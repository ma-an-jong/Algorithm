package Algorithm.컵.KSAAC;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class 그래서_대회_이름_뭐로하죠 {
    static int N;
    static int M;
    static String S;
    static List<Character> list = List.of('A','E','I','O','U');
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        S = br.readLine();

        if(!S.contains("A")) {
            System.out.println("NO");
            return;
        }

        if(N == M) {
            int lastIndex = S.length()-1;
            boolean flag = S.charAt(lastIndex-2) == 'A' &&
            S.charAt(lastIndex-1) == 'A' &&
                    (!list.contains(S.charAt(lastIndex)));

            if(flag) {
                System.out.println("YES");
                System.out.println(S);
            }
            else {
                System.out.println("NO");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(S.charAt(i) != 'A' || i < M-3) continue;
            for (int j = i+1; j < N; j++) {
                if(S.charAt(j) != 'A') continue;
                for (int k = j+1; k < N; k++) {

                    if(list.contains(S.charAt(k))) continue;

                    StringBuilder sb = new StringBuilder();
                    sb.append(S, 0, M-3);
                    sb.append(S.charAt(i));
                    sb.append(S.charAt(j));
                    sb.append(S.charAt(k));

                    System.out.println("YES");
                    System.out.println(sb.toString());
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}

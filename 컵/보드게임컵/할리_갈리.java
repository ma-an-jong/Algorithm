package Algorithm.컵.보드게임컵;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 할리_갈리 {

    static String[] d = {"BANANA","STRAWBERRY","LIME","PLUM"};
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[4];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            String name = str[0];
            int c = Integer.parseInt(str[1]);

            for (int j = 0; j < 4; j++) {
                if(name.equals(d[j])) {
                    cnt[j]+= c;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if(cnt[i] == 5) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}

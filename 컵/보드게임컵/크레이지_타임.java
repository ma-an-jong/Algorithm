package Algorithm.컵.보드게임컵;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 크레이지_타임 {

    static int[] time = new int[12];
    static int[] d = {1,-1};
    static int index = 0;
    static String HOURGLASS = "HOURGLASS";
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 12; i++) {
            time[i-1] = i;
        }
        int N = Integer.parseInt(br.readLine());
        int now = 11;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            String item = str[0];
            Integer t = Integer.parseInt(str[1]);

            now = (int)((now + d[index] + 12) % 12);
            if(time[now] == t && item.equals(HOURGLASS)) {
                bw.write(time[now] +" NO\n");
            }
            else if(time[now] == t) {
                bw.write(time[now] + " YES\n");
            }
            else if(item.equals(HOURGLASS)){
                bw.write(time[now] +" NO\n");
                index = index == 0 ? 1 : 0;
            }
            else {
                bw.write(time[now] +" NO\n");
            }
        }

        bw.flush();


    }
}

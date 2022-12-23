package Algorithm;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Stub {
    public static void stub() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testcase.txt")));

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }

        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }
}

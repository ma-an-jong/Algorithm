package Algorithm.Trying;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> s = new Stack<>();
        long ans = 0;
        line = line.replace("()","X");
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)=='X'){
                ans += s.size();
            }
            else if(line.charAt(i) == ')') {
                s.pop();
            }
            else {
                s.push('(');
                ans++;
            }
        }

        System.out.println(ans);
    }
}

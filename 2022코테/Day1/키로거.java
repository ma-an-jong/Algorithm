package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 키로거 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        int testcase = Integer.parseInt(str);

        for(int t = 0 ; t < testcase;t++)
        {
            str = br.readLine();

            Stack<Character> collector = new Stack<>();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < str.length();i++)
            {
                char c = str.charAt(i);

                if(c == '<')
                {
                    if(!stack.isEmpty())
                    {
                        collector.push(stack.pop());
                    }
                }
                else if(c == '>')
                {
                    if(!collector.isEmpty())
                    {
                        stack.push(collector.pop());
                    }
                }
                else if(c == '-')
                {
                    if(!stack.isEmpty())
                    {
                        stack.pop();
                    }
                }
                else {
                    stack.push(c);
                }
            }

            for(char c : stack){
                if(c != '\u0000')
                {
                    bw.write(c);
                }

            }

            while(!collector.isEmpty())
            {
                bw.write(collector.pop());
            }
            bw.write("\n");

        }
        bw.flush();
        bw.close();

    }
}

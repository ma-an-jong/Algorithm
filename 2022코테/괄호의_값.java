package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 괄호의_값 {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;

        for(int i = 0 ; i < str.length(); i++)
        {
            char c = str.charAt(i);

            if(c == '(')
            {
                tmp *= 2;
                stack.push(c);
            }
            else if(c == '[')
            {
                tmp *= 3;
                stack.push(c);
            }
            else if(c == ')')
            {
                if(stack.isEmpty() || stack.peek() != '(')
                {
                    ans = 0;
                    break;
                }
                else
                {
                    if(str.charAt(i - 1) == '(')
                    {
                        ans += tmp;
                    }

                    tmp /= 2;
                    stack.pop();
                }
            }
            else if(c == ']')
            {
                if(stack.isEmpty() || stack.peek() != '[')
                {
                    ans = 0;
                    break;
                }
                else
                {
                    if(str.charAt(i - 1) == '[')
                    {
                        ans += tmp;
                    }

                    tmp /= 3;
                    stack.pop();
                }
            }

        }

        if(!stack.isEmpty())
        {
            System.out.println(0);
        }
        else {
            System.out.println(ans);
        }






    }
}

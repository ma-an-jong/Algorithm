package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 문자열_폭발 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();


        for(int j = 0; j < bomb.length() -1;j++)
        {
            stack.push(str.charAt(j));
        }

        for(int i = bomb.length() -1; i < str.length();i++)
        {
            stack.push(str.charAt(i));

            try{
                boolean flag = true;

                for(int j = 0; j < bomb.length();j++)
                {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j) )
                    {
                        flag= false;
                        break;
                    }
                }

                if(flag)
                {
                    for(int j = 0; j < bomb.length();j++)
                    {
                        stack.pop();
                    }
                }
            }
            catch (Exception e)
            {
                continue;
            }


        }

        if(stack.isEmpty())
        {
            System.out.println("FRULA");
        }
        else {
            for(Character c : stack)
            {
                bw.write(c);
            }
            bw.flush();

        }


    }
}

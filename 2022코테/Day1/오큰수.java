package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수 {
    public static void main(String args[]) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        int N = Integer.parseInt(str);

        int arr[] = new int[N];
        String s[] = br.readLine().split(" ");

        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(s[i]);
        }

        Stack<Integer> stack = new Stack<>();

        int ans[] = new int[N];

        for(int i = N-1 ; i >= 0 ; i--)
        {
            if(stack.isEmpty())
            {
                stack.push(arr[i]);
                ans[i] = -1;
            }
            else if(stack.peek() > arr[i])
            {
                ans[i] = stack.peek();
                stack.push(arr[i]);
            }
            else
            {
                stack.pop();
                i++;
            }

        }

    for(int b : ans)
    {
        bw.write(b +"\n");
    }
    bw.flush();
    bw.close();
    }
 }

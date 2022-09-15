package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        char[] row = new char[s1.length()+1];
        for(int i = 0 ; i < s1.length();i++)
        {
            row[i+1] = s1.charAt(i);
        }
        char[] col = new char[s2.length()+1];
        for(int i = 0 ; i < s2.length();i++)
        {
            col[i+1] = s2.charAt(i);
        }

        int[][] arr = new int[1001][1001];

        for(int i = 1; i < col.length;i++)
        {
            for(int j = 1; j < row.length;j++)
            {
                if(col[i] == row[j])
                {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else
                {
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }

        int y = col.length-1;
        int x = row.length-1;
        Stack<Character> stack = new Stack<>();
        System.out.println(arr[y][x]);

        while(true)
        {
            if(arr[y][x] == 0)
            {
                break;
            }
            else if(arr[y][x] == arr[y][x-1])
            {
                x--;
            }
            else if(arr[y][x] == arr[y-1][x])
            {
                y--;
            }
            else
            {
                stack.push(row[x]);
                y--;
                x--;
            }
        }
        while(!stack.isEmpty())
        {
            bw.write(stack.pop() + "");
        }
        bw.flush();



    }
}

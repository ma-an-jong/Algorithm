package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 가장긴증가하는부분수열5 {
    static int lowerbound(int arr[],int value)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(arr[mid] >= value)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }

    static class Node
    {
        int value;
        int index;

        Node(int value,int index)
        {
            this.value = value;
            this.index = index;
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int arr[] = new int[N];

        for(int i = 0 ; i < N;i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }

        int select[] = new int[N];
        Arrays.fill(select,Integer.MAX_VALUE);

        Stack<Node> stack[] = new Stack[N];

        for(int i = 0 ; i < stack.length;i++)
        {
            stack[i] = new Stack<>();
        }

        for(int i = 0 ; i < N; i++)
        {
            int idx = lowerbound(select,arr[i]);
            select[idx] = arr[i];
            stack[idx].push(new Node(arr[i],i));
        }

        Stack<Node> ans = new Stack<>();

        Node prev = new Node(Integer.MAX_VALUE,N);

        for(int i = stack.length - 1; i >=0 ;i--)
        {

            while(!stack[i].isEmpty())
            {
                Node now = stack[i].pop();

                if(prev.index > now.index && prev.value > now.value)
                {
                    ans.push(new Node(now.value,now.index));
//                    System.out.println("if: " + now.value + " " +prev.value +" && "+now.index+ ":" +prev.index );
                    break;
                }
//                else
//                {
//                    System.out.println("else: " + now.value + " " +prev.value +" && "+now.index+ ":" +prev.index );
//                }
            }

            try
            {
                prev = ans.peek();
            }
            catch (Exception e)
            {

            }
        }
        int count = 0;

        for(int i = 0 ; i < N;i++)
        {
            if(select[i] != Integer.MAX_VALUE)
            {
                count++;
            }
        }

        bw.write(count + "\n");

        while(!ans.isEmpty())
        {
            Node node = ans.pop();
            bw.write(node.value + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

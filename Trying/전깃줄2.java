package Algorithm.Trying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 전깃줄2 {

    static int lowerbound(int arr[],int value)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(arr[mid] >= value)
            {
                high =  mid- 1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }

    static class Edge{
        int a;
        int b;

        Edge(int a,int b)
        {
            this.a = a;
            this.b = b;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Edge> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N;i++)
        {
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list.add(new Edge(a,b));
            max = Integer.max(max,a);
        }

        max++;

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.a - o2.a;
            }
        });

        int select[] = new int[max];
        Stack<Edge>[]  stack= new Stack[max];
        Arrays.fill(select,Integer.MAX_VALUE);

        boolean selected[] = new boolean[max];

        for(int i = 0 ; i < stack.length;i++)
        {
            stack[i] = new Stack<Edge>();
        }

        for(int i = 0 ; i < list.size();i++)
        {
            Edge edge = list.get(i);
            int idx = lowerbound(select,edge.b);
            select[idx] = edge.b;
            stack[idx].push(edge);
        }

        Edge node = new Edge(Integer.MAX_VALUE,Integer.MAX_VALUE);

        int count = 0;
        for(int i = max-1;i>=0;i--)
        {
            while(!stack[i].isEmpty())
            {
                Edge n = stack[i].pop();

                if(n.a < node.a && n.b < node.b)
                {
                    node = n;
                    selected[n.a] = true;
                    count++;
                    break;
                }
            }
        }

        bw.write((N - count) + "\n");

        for(int i =0; i < list.size();i++)
        {
            Edge edge = list.get(i);
            if(!selected[edge.a]) {
                bw.write(edge.a + "\n");
            }
        }

        bw.flush();

    }
}

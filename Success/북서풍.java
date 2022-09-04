package Algorithm.Success;
import java.io.*;
import java.util.*;

public class 북서풍 {
    static class Node{
        int x;
        int y;
        Node(int x,int y)
        {
            this.x = x;
            this.y = y;
        }

    }

    static long solve(long arr[],int idx,int currentLeft,int currentRight,int left,int right)
    {
        if(currentLeft > right || currentRight < left) return 0;
        if(currentLeft >= left && currentRight <= right) return arr[idx];

        long l = solve(arr,idx*2,currentLeft , (currentLeft+currentRight)/2,left,right);
        long r = solve(arr,idx*2 + 1, (currentLeft + currentRight)/2 + 1, currentRight,left,right);

        return l + r;
    }

    static void setTree(long arr[],int idx,long v)
    {
        arr[idx] = v;

        while(idx != 1)
        {
            idx /= 2;
            arr[idx] = arr[idx*2] + arr[idx*2 + 1];
        }
    }

    static int start = 1;
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t< testcase;t++)
        {
            int b = Integer.parseInt(br.readLine());

            List<Node> nodes = new ArrayList<>();

            for(int i = 0 ; i < b;i++)
            {
                String str[] = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                nodes.add(new Node(x,y));
            }

            Collections.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.y- o1.y;
                }
            });

            HashSet<Integer> xset = new HashSet<>();
            HashSet<Integer> yset = new HashSet<>();

            for(int i = 0 ; i < nodes.size();i++)
            {
                xset.add(nodes.get(i).x);
                yset.add(nodes.get(i).y);
            }

//            List<Integer> xlist = new ArrayList<>(xset);
//            List<Integer> ylist = new ArrayList<>(yset);
//
//            HashMap<Integer,Integer> xmap = new HashMap<>();
//            HashMap<Integer,Integer> ymap = new HashMap<>();
//
//            for(int i = 0 ; i < xlist.size();i++)
//            {
//                xmap.put(xlist.get(i),i);
//            }
//
//            for(int i = 0 ; i < ylist.size();i++)
//            {
//                ymap.put(ylist.get(i),i);
//            }
//
//            for(int i = 0 ; i < nodes.size();i++)
//            {
//                nodes.get(i).x = xmap.get(nodes.get(i).x);
//                nodes.get(i).y = ymap.get(nodes.get(i).y);
//            }

            int ny = 0;
            int prev = nodes.get(0).y;
            for(Node n : nodes)
            {
                if(n.y == prev)
                {
                    n.y = ny;
                    continue;
                }
                prev = n.y;
                n.y = ++ny;
            }

            Collections.sort(nodes, new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                    int rs = n1.x - n2.x;
                    if(rs == 0) rs = n1.y - n2.y;
                    return rs;
                }
            });

            long ans = 0L;

            start = 1;

            while (start < b)
            {
                start *= 2;
            }

            long[] tree = new long[start*3];

            for(Node node : nodes){
                ans += solve(tree,1 ,0, start-1, 0, node.y);
                setTree(tree, start + node.y, tree[start + node.y] + 1);
            }

            bw.write(ans+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


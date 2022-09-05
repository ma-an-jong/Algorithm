package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;

public class 디스크_트리 {
    static final String slash = "\\\\";

    static class Trie{
        Node root = new Node("");

        private static class Node{
            Map<String,Node> child = new TreeMap<String,Node>();
            String data;

            Node(String data) {this.data = data;}
            Node(){}
        }

        void insert(String str[])
        {
            Node node = root;

            for(int i = 0 ; i < str.length;i++)
            {
                Node n = node.child.get(str[i]);
                if(n==null)
                {
                    n = new Node(str[i]);
                    node.child.put(str[i],n);
                }
                node = n;
            }
        }

        void print(BufferedWriter bw) throws Exception
        {
            print(root,"",bw);
        }

        private void print(Node node,String padding, BufferedWriter bw)
        {
            String nextPadding = padding+" ";
            node.child.forEach((String key,Node n) ->
            {
                try
                {
                    bw.write(padding + n.data +"\n");
                    print(n,nextPadding,bw);
                }
                catch (Exception e)
                {

                }
            });

        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Trie trie = new Trie();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N;i++)
        {
            String str[] = br.readLine().split(slash);
            trie.insert(str);
        }
        trie.print(bw);
        bw.flush();


    }
}

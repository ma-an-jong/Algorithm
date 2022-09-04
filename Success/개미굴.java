package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 개미굴 {
    static class Trie{

        Node root = new Node("");
        private static class Node
        {
            Map<String,Node> childNode = new TreeMap<String,Node>();
            String data;
            Node(String data){this.data = data;}
        }

        void insert(String str[])
        {
            Node node = root;
            for(int i = 0 ; i < str.length;i++)
            {
                Node n = node.childNode.get(str[i]);
                if(n == null)
                {
                    n = new Node(str[i]);
                    node.childNode.put(str[i],n);
                }
                node = n;
            }
        }

        void print(BufferedWriter bw) throws Exception
        {
            root.childNode.forEach((String key,Node next) -> {
                try {
                    bw.write(next.data+"\n");
                    print(next,"--",bw);
                }
                catch (Exception e) {}
            });

        }

        private void print(Node node,String padding,BufferedWriter bw) throws Exception
        {
            if(node.childNode.size() == 0)
            {
                return;
            }

            String nextPadding = padding + "--";
            node.childNode.forEach((String key,Node next) -> {
                try {
                    bw.write(padding + next.data+"\n");
                    print(next,nextPadding,bw);
                }
                catch (Exception e) {}
            });
        }



    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i = 0 ; i < N ; i++)
        {
            String str[] = br.readLine().split(" ");
            trie.insert(Arrays.copyOfRange(str,1,str.length));
        }

        trie.print(bw);
        bw.flush();
    }
}

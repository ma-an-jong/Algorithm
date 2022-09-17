package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class 휴대폰_자판 {
    static class Trie{
        Node root = new Node('\u0000');
        static class Node
        {
            char c;
            boolean isSubset = false;
            Map<Character,Node> child = new TreeMap<>();
            Node(char c) {this.c = c;}
        }

        void insert(String str)
        {
            Node node = root;
            for(int i = 0 ; i < str.length();i++)
            {
                Node n = node.child.get(str.charAt(i));
                if(n == null)
                {
                    n = new Node(str.charAt(i));
                    node.child.put(str.charAt(i),n);
                }
                node = n;
            }
            node.isSubset = true;
        }
        int autocomplete(String str)
        {
            Node node = root;
            int cnt = 0;
            for(int i = 0; i < str.length();i++) {
                node = node.child.get(str.charAt(i));
                if(node.isSubset || node.child.size() > 1)
                {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       while(true)
       {
           try
           {
               int N = Integer.parseInt(br.readLine());
               Trie trie = new Trie();
               String str[] = new String[N];
               for(int i = 0 ; i < N;i++)
               {
                   str[i] = br.readLine();
                   trie.insert(str[i]);
               }
               Double sum = 0.0;
               for(int i = 0 ; i < N;i++)
               {
                   int cnt = trie.autocomplete(str[i]);
                   sum+= cnt;
               }
               sum /= N;
               bw.write(String.format("%.2f\n" , sum));
           }
           catch (Exception e)
           {
                break;
           }
       }
       bw.flush();


    }
}

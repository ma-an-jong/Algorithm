package Algorithm.Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 게임_닉네임 {

    static class Trie{
        Node root = new Node('\u0000');

        private static class Node {
            Map<Character,Node> child = new TreeMap<Character,Node>();
            Character data;

            Node(Character c){
                data = c;
            }
        }

        void insert(String s) throws Exception
        {

            if(s.equals(null)) return;

            Node node = root;
            boolean flag = false;
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < s.length();i++)
            {
                Node n = node.child.get(s.charAt(i));
                if(!flag)
                {
                    bw.write(s.charAt(i)+"");
                    sb.append(s.charAt(i));
                }
                if(n==null)
                {
                    n = new Node(s.charAt(i));
                    node.child.put(s.charAt(i),n);
                    flag = true;
                }

                node = n;
            }

            if(!flag && map.containsKey(s))
            {
                int count = map.get(s);
                bw.write((count +1)+"");
                map.put(s,count+1);
            }

            if(!map.containsKey(s)) map.put(s,1);
        }


    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String ,Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i = 0 ; i < N;i++)
        {
            String s = br.readLine();
            trie.insert(s);
            if(i==N-1) break;
            bw.newLine();
        }

        bw.flush();

    }
}

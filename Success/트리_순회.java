package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class 트리_순회 {
    static int N;

    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
        }

        Node(Node left,Node right, String value) {
            this.value =value;
            this.left = left;
            this.right = right;
        }

        String vlr(){
            String s = value;
            if(left != null) s += left.vlr();
            if(right != null) s += right.vlr();
            return s;
        }

        String lvr(){
            String s = "";
            if(left != null) s = left.lvr();
            s += value;
            if(right != null) s += right.lvr();
            return s;
        }

        String lrv(){
            String s = "";
            if(left != null) s = left.lrv();
            if(right != null) s += right.lrv();
            s += value;
            return s;
        }
    }


    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Map<String,Node> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            String s = String.valueOf((char)('A' + i));
            map.put(s,new Node(s));
        }

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            Node parent = map.get(str[0]);

            if(!str[1].equals(".")) {
                Node left = map.get(str[1]);
                parent.left = left;
            }

            if(!str[2].equals(".")) {
                Node right = map.get(str[2]);
                parent.right = right;
            }
        }


        Node node = map.get("A");

        bw.write(node.vlr() + "\n");
        bw.write(node.lvr() + "\n");
        bw.write(node.lrv());

        bw.flush();





    }
}

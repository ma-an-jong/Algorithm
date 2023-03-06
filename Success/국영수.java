package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 국영수 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int z;
        String name;

        public Node(int x, int y, int z, String name) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            if(x != o.x) return o.x - x;
            if(y != o.y) return y - o.y;
            if(z != o.z) return o.z - z;

            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            String name = str[0];
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            int z = Integer.parseInt(str[3]);
            nodes.add(new Node(x,y,z,name));
        }

        Collections.sort(nodes);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            bw.write(nodes.get(i).name +"\n");
        }

        bw.flush();

    }
}

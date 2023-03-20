package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 사분면 {
    static int d;
    static String s;
    static long x;
    static long y;

    static class Node {
        long y;
        long x;

        public Node(long y, long x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean check(String str){
        for (int i = 0; i < str.length(); i++) {
            if('0' >= str.charAt(i) || str.charAt(i) >= '5') {
                return false;
            }
        }
        return true;
    }


    static Node find(long sy,long sx, long ey, long ex,int i) {

        if(i == s.length()) {
            return new Node(sy,sx);
        }

        char target = s.charAt(i);


        for (int j = 0; j < 4; j++) {
            char k = (char)('1' + j);
            if(k == target){

                if(k == '1') return find(sy,(ex + sx)/2 + 1,(sy + ey)/2, ex,i+1);

                if(k == '2') return find(sy,sx,(sy + ey)/2 ,(ex + sx)/2,i+1);

                if(k == '3') return find((ey + sy)/2 + 1,sx,ey,(ex + sx)/2,i+1);

                return find((ey + sy)/2 + 1,(ex + sx)/2 + 1,ey , ex,i+1);
            }
        }
        return null;
    }
    static StringBuilder sb = new StringBuilder();
    static String find(long sy, long sx,long ey,long ex,Node node) {
        if(ey == sy && sx == ex) {
            return sb.toString();
        }

        if(node.y >= sy && node.x >= (ex+sx)/2 + 1 && (sy+ey)/2 >= node.y && ex >= node.x) {
            sb.append("1");
            return find(sy,(ex + sx)/2 + 1,(sy + ey)/2, ex,node);
        }
        if(node.y >= sy && node.x >= sx && (sy + ey)/2 >= node.y && (ex + sx)/2 >= node.x) {
            sb.append("2");
            return find(sy,sx,(sy + ey)/2 ,(ex + sx)/2,node);
        }
        if(node.y >= (ey + sy)/2 + 1 && node.x >= sx && ey >= node.y && (ex + sx)/2 >= node.x) {
            sb.append("3");
            return find((ey + sy)/2 + 1,sx,ey,(ex + sx)/2,node);
        }
        if(node.y >= (ey + sy)/2 + 1 && node.x >= (ex + sx)/2 && ey >= node.y && ex >= node.x) {
            sb.append("4");
            return find((ey + sy)/2 + 1,(ex + sx)/2 + 1,ey , ex,node);
        }

        return null;
    }




    public static void main(String[] args) throws Exception{
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        d = Integer.parseInt(str[0]);
        s = str[1];

        if(!check(s)) {
            System.out.println("-1");
            return;
        }

        str = br.readLine().split(" ");
        x = Long.parseLong(str[0]);
        y = Long.parseLong(str[1]);


        Node node = find(0, 0, (long) (Math.pow(2, d) - 1), (long) (Math.pow(2, d) - 1), 0);

        node.x  += x;
        node.y -= y;
        if(node.x < 0 || node.x >= Math.pow(2,d) || node.y < 0 || node.y >= Math.pow(2,d)) {
            System.out.println("-1");
            return;
        }
        String ans = find(0, 0, (long) (Math.pow(2, d) - 1), (long) (Math.pow(2, d) - 1), node);
        System.out.println(ans);
    }
}

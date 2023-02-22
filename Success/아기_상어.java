package Algorithm.특강;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 아기_상어 {

    static int N;
    static int[][] arr;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static Comparator<Point> comparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.cost - o2.cost != 0) {
                return o1.cost - o2.cost;
            } else if(o1.y - o2.y != 0) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        }
    };

    static class Point implements Comparable<Point>{
        int y;
        int x;
        int cost;

        public Point(int y, int x,int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return cost - o.cost;
        }
    }

    public static Point findNearest(Point point,int size) {
        Queue<Point> q = new PriorityQueue<>();
        q.add(point);
        boolean[][] visited = new boolean[N][N];
        visited[point.y][point.x] = true;
        List<Point> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Point p = q.remove();

            for (int i = 0; i < 4; i++) {
                int y = p.y + dy[i];
                int x = p.x + dx[i];

                if(y < 0 || x < 0 || y >= N || x >= N) continue;
                if(visited[y][x]) continue;
                visited[y][x] = true;
                if(arr[y][x] == 0 || arr[y][x] == size) {
                    q.add(new Point(y,x,p.cost+1));
                } else if(arr[y][x] < size) {
                    list.add(new Point(y,x,p.cost+1));
                }
            }
        }

        list.sort(comparator);
        if(list.size() == 0) return null;
        Point nearest = list.get(0);
        arr[nearest.y][nearest.x] = 0;
        return nearest;
    }

    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int size = 2;
        int cnt = 0;
        Point p = null;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j] == 9) {
                    p = new Point(i,j,0);
                    arr[i][j] = 0;
                }
            }
        }

        while(p != null) {

            if(size == cnt) {
                size ++;
                cnt = 0;
            }

            Point next = findNearest(p,size);
            if(next == null) {
                System.out.println(p.cost);
                return;
            }

            p = next;
            cnt++;
        }

    }
}

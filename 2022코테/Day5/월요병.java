package Day5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 월요병 {
    static class Position implements Comparable<Position>{
        int x;
        int y;
        long cost;

        Position(int x,int y,long cost)
        {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            if(this.cost > o.cost)
            {
                return 1;
            }
            else if(this.cost == o.cost)
            {
                return 0;
            }
            else return -1;
        }
    }
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");


        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        long map[][] = new long[N+2][M+2];
        long visited[][] = new long[N+2][M+2];

        for(int i = 0 ; i < N;i++)
        {
            str = br.readLine().split(" ");
            for(int j = 0 ; j < M;j++)
            {
                long value = Long.parseLong(str[j]);
                map[i+1][j+1] = value == -2 ? 0 : value;
            }
        }

        for(int i = 0 ; i < N+2;i++)
        {
            for(int j = 0 ; j < M+2;j++)
            {
                if(map[i][j] == -1)
                {
                    visited[i][j] = Integer.MIN_VALUE;
                }
                else
                {
                    visited[i][j] = Long.MAX_VALUE;
                }
            }
        }

        visited[0][0] = Integer.MIN_VALUE;
        visited[0][1] = Integer.MIN_VALUE;

        visited[N+1][M+1] = Integer.MIN_VALUE;
        visited[N+1][M] = Integer.MIN_VALUE;
        visited[N][M+1] = Integer.MIN_VALUE;

        PriorityQueue<Position> pq = new PriorityQueue<>();

        pq.add(new Position(0,1,0));
        visited[1][0] = 0;

        int dx[] = {-1,1,0,0,-1,1,-1,1};
        int dy[] = {0,0,-1,1,-1,-1,1,1};

        while(!pq.isEmpty())
        {
            Position p = pq.remove();

            if(visited[p.y][p.x] < p.cost) continue;

            for(int i = 0 ; i < 8;i++)
            {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                try
                {
                    if(visited[y][x] > map[y][x] + p.cost)
                    {
                        visited[y][x] = map[y][x] + p.cost;
                        pq.add(new Position(x,y,visited[y][x]));
                    }
                }
                catch (Exception e)
                {
                    continue;
                }
            }
        }
//
//        for(int i = 0 ; i < N+2;i++)
//        {
//            for(int j = 0 ; j < M+2;j++)
//            {
//                System.out.print(visited[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(visited[0][M+1] == Long.MAX_VALUE ? -1 : visited[0][M+1]);
    }
}

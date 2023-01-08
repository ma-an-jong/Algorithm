package Algorithm.SWExpert;

import Algorithm.Stub;

import java.util.*;
class 기념품_수집
{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] cities;
    static int R;
    static int C;

    static int foo(int x,int y ,int count,boolean[] memento) {
        int ans = count;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;

            boolean[] newMemento = new boolean[26];

            for (int j = 0; j < 26; j++) {
                newMemento[j] = memento[j];
            }

            if(!newMemento[cities[ny][nx] - 'A']) {
                newMemento[cities[ny][nx] - 'A'] = true;
                ans = Math.max(foo(nx,ny,count + 1,newMemento),ans);
                newMemento[cities[ny][nx] - 'A'] = false;
            }

        }
        return ans;

    }
    public static void main(String[] args) throws Exception
    {
        Stub.stub();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            R = sc.nextInt();
            C = sc.nextInt();
            cities = new char[R][C];
            for(int r = 0; r < R;r++){
                String line = sc.next();
                for(int c = 0;c < C;c++){
                    cities[r][c] = line.charAt(c);
                }
            }

            boolean[] memento = new boolean[26];
            memento[cities[0][0] - 'A'] = true;
            System.out.println("#" + test_case +" "+foo(0,0,1,memento));
        }
    }
}

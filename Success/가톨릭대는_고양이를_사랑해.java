package Algorithm.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 가톨릭대는_고양이를_사랑해 {

    static class Position{
        int x;
        int y;

        Position(int x,int y)
        {
            this.x=x;
            this.y=y;
        }

    }

    static int lowerbound(Position arr[],Position value)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(arr[mid] == null) {
                high = mid -1;
                continue;
            }

            if(arr[mid].x >= value.x)
            {
                if(arr[mid].y > value.y)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(arr[mid].y <= value.y)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }

            }
        }

        return low;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int T = Integer.parseInt(br.readLine());
        ArrayList<Position> list = new ArrayList<>();
        for(int i = 0 ; i < T;i++)
        {
            str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);

            if(x > M || y > N) continue;
            list.add(new Position(x,y));
        }
        Collections.sort(list, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.x == o2.x)
                {
                    return o1.y -o2.y;
                }

                return o1.x - o2.x;
            }
        });

        Position[] arr = new Position[T];

        for(int i = 0 ; i < list.size();i++)
        {
            Position pos = list.get(i);
//            System.out.print(pos.x + " " + pos.y +" ");
            int idx = lowerbound(arr,pos);
            arr[idx] = new Position(pos.x,pos.y);
//            System.out.println(idx);
        }
        int count = 0;
        for(int i = 0 ; i < arr.length;i++)
        {
            if(arr[i] != null)
            {
                count++;
            }
        }
        System.out.println(count);

    }
}

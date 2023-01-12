package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 트리플렛 {

    public static class Coord
    {
        int x;
        int y;


        Coord(int x,int y)
        {
            this.x = x;
            this.y = y;
        }

    }


    public static boolean isStraight(Coord a , Coord b,Coord c)
    {
        if((a.x - c.x)*(a.y - b.y) == (a.x - b.x)*(a.y - c.y))
        {
            return true;
        }

        return false;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();
        int N = Integer.parseInt(str);

        char [][]map = new char[N][N];

        for(int i = 0 ; i < N ; i++)
        {
            str = br.readLine();

            for(int j = 0 ; j < N;j++)
            {
                map[i][j] = str.charAt(j);
            }
        }

        ArrayList<Coord> list = new ArrayList<>();

        for(int i = 0 ; i < N;i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] != '.')
                {
                    list.add(new Coord(j,i));
                }
            }
        }
        int cnt = 0;

        for(int i = 0 ; i < list.size();i++)
        {
            Coord a = list.get(i);
            for (int j = i+1;j< list.size();j++)
            {
                Coord b = list.get(j);
                for(int k = j+1 ; k < list.size();k++)
                {
                    Coord c = list.get(k);

                    if(isStraight(a,b,c)){
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);



    }
}

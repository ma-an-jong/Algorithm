package Day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 킹 {
    static int mappingX(char c)
    {
        if(c == 'A')
        {
            return 0;
        }
        else if(c == 'B')
        {
            return 1;
        }
        else if(c == 'C')
        {
            return 2;
        }
        else if(c == 'D')
        {
            return 3;
        }
        else if(c == 'E')
        {
            return 4;
        }
        else if(c == 'F')
        {
            return 5;
        }
        else if(c == 'G')
        {
            return 6;
        }
        else if(c == 'H')
        {
            return 7;
        }

        return 0;

    }
    static int mappingY(char c)
    {
        return 8 - (c- '0');
    }

    static boolean move(Pair p , String s)
    {
        if(s.equals("R"))
        {
            if(p.x + 1 >= 8){
                return false;
            }
            p.x++;
        }
        else if(s.equals("L"))
        {
            if(p.x - 1 < 0){
                return false;
            }
            p.x--;
        }
        else if(s.equals("B"))
        {
            if(p.y + 1 >= 8){
                return false;
            }
            p.y++;
        }
        else if(s.equals("T"))
        {
            if(p.y - 1 < 0){
                return false;
            }
            p.y--;
        }
        else if(s.equals("RT"))
        {
            if(p.y - 1 < 0 || p.x + 1 >=8){
                return false;
            }
            p.x++;
            p.y--;
        }
        else if(s.equals("LT"))
        {
            if(p.x - 1 < 0 || p.y - 1 < 0){
                return false;
            }

            p.x--;
            p.y--;
        }
        else if(s.equals("RB"))
        {
            if(p.x + 1 >=8 || p.y + 1 >= 8){
                return false;
            }

            p.x++;
            p.y++;
        }
        else if(s.equals("LB"))
        {
            if(p.x - 1 < 0 || p.y + 1 >=8 ){
                return false;
            }
            p.x--;
            p.y++;
        }
        return true;
    }
    static boolean valid(Pair p , String s)
    {
        if(s.equals("R"))
        {
            if(p.x + 1 >= 8){
                return false;
            }
        }
        else if(s.equals("L"))
        {
            if(p.x - 1 < 0){
                return false;
            }
        }
        else if(s.equals("B"))
        {
            if(p.y + 1 >= 8){
                return false;
            }
        }
        else if(s.equals("T"))
        {
            if(p.y - 1 < 0){
                return false;
            }
        }
        else if(s.equals("RT"))
        {
            if(p.y - 1 < 0 || p.x + 1 >=8){
                return false;
            }
        }
        else if(s.equals("LT"))
        {
            if(p.x - 1 < 0 || p.y - 1 < 0){
                return false;
            }
        }
        else if(s.equals("RB"))
        {
            if(p.x + 1 >=8 || p.y + 1 >= 8){
                return false;
            }
        }
        else if(s.equals("LB"))
        {
            if(p.x - 1 < 0 || p.y + 1 >=8 ){
                return false;
            }
        }
        return true;
    }
    static String ans(int x,int y)
    {
        String s = "";
        if(x == 0)
        {
            s+= 'A';

        }
        else if(x == 1)
        {
            s+= 'B';
        }
        else if(x == 2)
        {
            s+= 'C';
        }
        else if(x == 3)
        {
            s+= 'D';
        }
        else if(x == 4)
        {
            s+= 'E';
        }
        else if(x == 5)
        {
            s+= 'F';
        }
        else if(x == 6)
        {
            s+= 'G';
        }
        else if(x == 7)
        {
            s+= 'H';
        }

        s+= (8 - y);

        return s;
    }
    static class Pair{
        int x;
        int y;

        Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        Pair king = new Pair(mappingX(str[0].charAt(0)),mappingY(str[0].charAt(1)));
        Pair stone = new Pair(mappingX(str[1].charAt(0)),mappingY(str[1].charAt(1)));
        int N = Integer.parseInt(str[2]);
        for(int i = 0; i < N; i++)
        {
            String s = br.readLine();
            Pair p = new Pair(king.x,king.y);
            move(p,s);
            boolean flag= valid(king,s);

            if(p.x == stone.x && p.y == stone.y)
            {
                if(valid(stone,s))
                {
                    move(king,s);
                    move(stone,s);
                }
            }
            else
            {
                move(king,s);
            }

        }

        System.out.println(ans(king.x,king.y));
        System.out.println(ans(stone.x,stone.y));






    }
}

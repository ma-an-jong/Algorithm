package Day1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
5
....X
..XX.
.....
.XX..
X....
 */
public class 누울_자리를_찾아라 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String str = br.readLine();

        int N = Integer.parseInt(str);

        char map[][] = new char[N][N];

        for(int i = 0 ; i < N ;i++)
        {
            str = br.readLine();
            for(int j = 0; j < N;j++)
            {
                map[i][j] = str.charAt(j);
            }
        }

        int width = 0;

        for(int i = 0 ; i < N ; i++)
        {
            boolean flag = true;
            for(int j = 0 ; j < N -1; j++)
            {
                if(map[i][j] == '.' && map[i][j+1] == '.')
                {
                    flag = false;
                }
                else if(map[i][j] == 'X')
                {
                    if(!flag) width++;
                    flag = true;
                }

            }
            if(!flag) width++;
        }

        int height = 0;

        for(int i = 0 ; i < N ; i++)
        {
            boolean flag = true;
            for(int j = 0 ; j < N -1; j++)
            {
                if(map[j][i] == '.' && map[j+1][i] == '.')
                {
                    flag = false;
                }
                else if(map[j][i] == 'X')
                {
                    if(!flag) height++;
                    flag = true;
                }

            }
            if(!flag) height++;
        }


        System.out.println(width +" " + height);













    }
}

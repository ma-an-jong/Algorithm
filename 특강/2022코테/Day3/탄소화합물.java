package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 탄소화합물 {

    static int map(char c){
        if(c == 'C')
        {
            return 0;
        }
        else if(c == 'H')
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    static int[] wordCount(String M1)
    {
        int count[] = new int[3];
        for(int i = 0 ; i < M1.length();i++)
        {
            char c = M1.charAt(i);

            if(i !=0  && '2' <= c && c<='9')
            {
                int idx = map(M1.charAt(i-1));

                for(int j = 0 ; j < c - '0' -1;j++)
                {
                    count[idx]++;
                }
            }
            else
            {
                int idx = map(c);
                count[idx]++;
            }
        }
        return count;
    }
    static boolean validation(int[] count1 , int[] count2, int count3[],int i, int j, int k)
    {
        if(count1[0]*i + count2[0]*j == count3[0]*k)
        {
            if(count1[1]*i + count2[1]*j == count3[1]*k )
            {
                if(count1[2]*i + count2[2]*j == count3[2]*k )
                {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split("=");

        String M3 = str[1];
        StringTokenizer st = new StringTokenizer(str[0],"+");

        String M1 = st.nextToken();
        String M2 = st.nextToken();

 //       'C', 'H', 'O', '2'∼'9'

        int count1[] = wordCount(M1);
        int count2[] = wordCount(M2);
        int count3[] = wordCount(M3);
        boolean flag = true;
        for(int i = 1; i <= 10;i++)
        {
            for(int j = 1; j <= 10;j++)
            {
                for(int k = 1; k <= 10;k++)
                {
                    if(flag && validation(count1,count2,count3,i,j,k))
                    {
                        System.out.println(i + " " + j + " " + k);
                        flag = false;
                    }
                }
            }
        }


    }
}

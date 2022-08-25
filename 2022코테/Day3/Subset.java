package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Subset {

    public static void Subset(int[] arr,int select[],int N,int idx)
    {
        if(idx == N)
        {
            int sum = 0;
            for(int i = 0 ; i < arr.length;i++)
            {
                if(select[i] == 1)
                {
                    sum += arr[i];
                }
            }
            if(sum == 0)
            {
                for(int i = 0 ; i < arr.length;i++)
                {
                    if(select[i] == 1)
                    {
                        System.out.print(arr[i] +" ");
                    }
                }
                System.out.println();
            }
            return;
        }

        select[idx] = 0;
        Subset(arr,select,N,idx+1);
        select[idx] = 1;
        Subset(arr,select,N,idx+1);
    }

    public static int comb(int select[], int N ,int R, int idx,int count)
    {
        if( R == count || N == idx)
        {
            return count;
        }

        int a = comb(select,N,R,idx+1,count);
        int b = comb(select, N,R,idx+1, count+1);

        return a+b;
    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int []arr = {9,3,6,2};
        int []select = new int[arr.length];

       for(int i = 0 ; i <= 4;i++)
       {
           comb(select,4,i,0,0);
       }


    }

}

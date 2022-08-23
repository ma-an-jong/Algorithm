package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수_정렬하기3 {
    public static void sort(int arr[],int L,int R)
    {
        if(L == R) return;

        int mid = (L + R) /2;

        sort(arr,L , mid );
        sort(arr,mid+1,R);

        int left = L;
        int right = mid+1;

        int tmp[] = new int[R-L+1];

        int cursor = 0;

        while(left <= mid && right <=R)
        {
            if(arr[left] <= arr[right])
            {
                tmp[cursor++] = arr[left++];
            }
            else {
                tmp[cursor++] = arr[right++];
            }
        }

        while(left <= mid)
        {
            tmp[cursor++] = arr[left++];
        }
        while(right <= R)
        {
            tmp[cursor++] = arr[right++];
        }

        for(int i = L ; i <= R;i++)
        {
            arr[i] = tmp[i-L];
        }

    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int N = Integer.parseInt(s);

        int radix[] = new int[10000+1];

        for(int i = 0; i < N ; i++)
        {
            int input = Integer.parseInt(br.readLine());
            radix[input]++;
        }

        for(int i = 1; i < radix.length;i++)
        {
            for(int j = 0; j < radix[i];j++)
            {
                bw.write(i+"\n");
            }
        }

        bw.flush();
    }


}

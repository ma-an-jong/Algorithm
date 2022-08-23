package Day2;

public class Merge {
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

    public static void main(String args[])
    {
        int arr[] = {1123,12,4,12,461,318,29,3,12,3,1,44,2,1,5,32,45,32};
        sort(arr,0,arr.length-1);
        for(int a : arr)
        {
            System.out.print(a + " ");
        }
    }

}

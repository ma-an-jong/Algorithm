package Day2;

public class QuickSort {
    static void sort(int[] arr,int L,int R)
    {
        int left = L;
        int right = R;

        int pivot = arr[(left+right)/2];

        while(left <= right)
        {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++; right--;
            }
        }

        if(L < right) sort(arr,L,right);
        if(R > left) sort(arr,left,R);
    }

    public static void main(String args[])
    {
        int arr[] = {1,313,1,41,234,14,1,1,54,423,42,34,2};
        sort(arr,0,arr.length-1);

        for(int a : arr)
        {
            System.out.print(a + " ");
        }
    }
}

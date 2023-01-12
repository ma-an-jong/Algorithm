package Day3;

public class Permutation {
    static int[] arr = {1,7,9,10,12};
    static int[] select = new int[arr.length];
    static int[] visited = new int[arr.length];

    public static void perm(int N,int R,int idx)
    {
        if (R == idx)
        {
            for(int i = 0 ; i < R;i++)
            {
                System.out.print(select[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < N;i++)
        {
            if(visited[i] == 0)
            {
                select[idx] = arr[i];
                visited[i] = 1;
                perm(N,R,idx+1);
                visited[i] = 0;
            }
        }
    }


    public static void main(String args[]){

//        for(int i = 0 ; i < arr.length;i++)
//        {
//            for(int j = 0 ; j < arr.length;j++)
//            {
//                if(i != j)
//                    for(int k = 0 ; k < arr.length;k++)
//                    {
//                        if(j != k && i != k)
//                            System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
//                    }
//            }
//        }

        perm(arr.length,3,0);
    }


}

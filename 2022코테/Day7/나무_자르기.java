    package Day7;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.util.Arrays;

    public class 나무_자르기 {
        public static void main(String args[]) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            long m = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");

            int tree[] = new int[n];

            int high = 0;
            int low = 0;

            for(int i = 0 ; i < n ;i++)
            {
                tree[i] = Integer.parseInt(str[i]);
                high = Math.max(high,tree[i]);
            }

            int ans = 0;

            while(low <= high)
            {
                int mid = (low+high)/2;

                long sum = 0L;
                for(int i = 0 ; i < n ;i++)
                {
                    if(tree[i] - mid > 0)
                    {
                        sum += tree[i] - mid ;
                    }
                }

                if(sum >= m)
                {
                    low = mid + 1;
                    ans = mid;
                }
                else
                {
                    high = mid -1;
                }


            }

            bw.write(ans+"");
            bw.flush();
        }

    }

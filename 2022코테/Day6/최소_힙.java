package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 최소_힙 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int heap[] = new int[100001];

        int idx = 1;

        for(int t = 0 ; t < N;t++)
        {
            int a = Integer.parseInt(br.readLine());

            if(a == 0)
            {
                if(idx == 1)
                {
                    bw.write("0\n");
                    continue;
                }

                int ans = heap[1];
                int d = heap[--idx];
                int child = 2;

                while(child < idx)
                {
                    if(child + 1 < idx)
                    {
                        if(heap[child+1] < heap[child])
                        {
                            child = child+1;
                        }
                    }

                    if(heap[child] > d)
                    {
                        break;
                    }
                    else
                    {
                        heap[child/2] = heap[child];
                    }

                    child *=2;
                }

                heap[child/2] =d;
                bw.write(ans+"\n");
            }
            else
            {
                int pre = idx;

                while(pre != 1)
                {
                    if(heap[pre/2] > a)
                    {
                        heap[pre] = heap[pre/2];
                        pre /= 2;
                    }
                    else {
                        break;
                    }
                }

                heap[pre] = a;
                idx++;
            }
        }

        bw.flush();

    }
}

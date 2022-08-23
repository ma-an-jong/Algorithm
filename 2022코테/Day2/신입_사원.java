package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 신입_사원 {
    static class Employee implements Comparable<Employee>{
        int x;
        int y;

        Employee(int x,int y)
        {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Employee o) {
            return this.x - o.x;
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int testcase = Integer.parseInt(s);

        for(int t = 0 ; t< testcase;t++)
        {
            s = br.readLine();
            int N = Integer.parseInt(s);
            Employee[] arr = new Employee[N];
            for(int i = 0 ; i < N ; i++)
            {
                String str[] = br.readLine().split(" ");
                arr[i] = new Employee(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            }

            Arrays.sort(arr);

            //Arrays.stream(arr).forEach(v -> System.out.println(v.x));

            int max = arr[0].y;
            int count = 0;

            for(int i = 0; i < arr.length;i++)
            {
                if(max >= arr[i].y)
                {
                    count++;
                    max = arr[i].y;
                }
            }

            bw.write(count+"\n");
        }
        bw.flush();

    }
}

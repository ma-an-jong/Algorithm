package Algorithm.컵.보라매컵본선;

import Algorithm.Stub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 장기자랑 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Stub.stub();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length-1;
        int sum = arr[j];
        int before = arr[j];
        j--;
        boolean flag = true;

        while(i <= j){
            if(flag){
                sum += Math.max(arr[i]-before,0);
                before = arr[i];
                i++;
                flag = false;
            }
            else {
                sum += Math.max(arr[j]-before,0);
                before = arr[j];
                j--;
                flag = true;
            }
        }
        System.out.println(sum);
    }
}


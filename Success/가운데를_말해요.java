package Algorithm.Success;

import Algorithm.Stub;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 가운데를_말해요 {
    public static void main(String[] args) throws Exception {
        Stub.stub();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int mid = Integer.parseInt(br.readLine());
        bw.write(mid+"\n");

        PriorityQueue<Integer> lessThenMid = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> moreThenMid = new PriorityQueue<>();

        for(int i = 0 ; i < N-1; i++){

            int value = Integer.parseInt(br.readLine());

            if(value > mid) moreThenMid.add(value);
            else lessThenMid.add(value);

            if(lessThenMid.size() > moreThenMid.size()){
                moreThenMid.add(mid);
                mid = lessThenMid.poll();
            }
            else if (moreThenMid.size() > lessThenMid.size() + 1){
                lessThenMid.add(mid);
                mid = moreThenMid.poll();
            }

            bw.write(mid+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

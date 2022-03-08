package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 하노이_탑_이동_순서 {

	public static void foo(int from,int to,int N) throws Exception {
		if(N==1){
	        bw.write(from + " " + to + "\n");
	        return;
	    }
	    int empty = 6-from-to;
	    foo(from, empty, N-1);
	    bw.write(from + " "+ to + '\n');
	    foo(empty, to, N-1);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		bw.write((long)(Math.pow(2,N) - 1) +"\n");
		foo(1,3,N);
		
		bw.flush();
	}
}

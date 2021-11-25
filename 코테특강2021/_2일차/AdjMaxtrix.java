package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class AdjMaxtrix {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		int w = Integer.parseInt(str[0]);
		int h = Integer.parseInt(str[1]);
		int size = Integer.parseInt(str[2]);
		int matrix[][] = new int[w][h];
		
		
		for(int i = 0 ; i < size; i++ ) {
			String tmp[] = br.readLine().split(" ");
			matrix[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
		}
		
		for(int i = 0; i < h;i++) {
			for(int j = 0 ; j <w;j++) {
				bw.write(matrix[j][i]+"");
			}
		bw.write("\n");
		}
		
		bw.flush();
		
	}
}
//7 >>정점의 수
//8 >> 간선의 수
//0 1
//0 2
//0 5
//0 6
//3 4
//3 5
//4 5
//4 6
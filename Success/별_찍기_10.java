package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class º°_Âï±â_10 {
		
	public static int foo(int x ,int y) throws Exception {
		  if (((x % 3) == 1) && ((y % 3) == 1)) 
			  return 1;
		  if (x == 0 || y == 0) 
			  return 0;
		  
		  return foo(x/3,y/3);
	}
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {

	int N = Integer.parseInt(br.readLine());
	
	for(int i = 0; i < N;i++) {
		for(int j = 0 ; j < N ; j++) {
			if(foo(i,j) == 0) 
			{
				bw.write("*");
			}
			else
			{
				bw.write(" ");
			}
		}
		bw.write("\n");
	}
	
	bw.flush();
	}

}

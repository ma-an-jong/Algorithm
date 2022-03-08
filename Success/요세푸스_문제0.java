package Success;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요세푸스_문제0 {
	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n ; i++) {
			list.add(i+1);
		}
		
		int cursor = 0;
		bw.write("<");
		for(int i = 0 ; i < n ; i++) {
			
			for(int j = 1; j < k ; j++) 
			{
					cursor = (cursor +1)%list.size();
			}
			
			int x  = list.remove(cursor);
			
			if(list.size() != 0)
				bw.write(x +", ");
			else
				bw.write(x+"");
		}
		
		bw.write(">");
		bw.flush();
		
		
	}
}

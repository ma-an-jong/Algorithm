package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 소트인사이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		for(int i = 1; i <= N ; i *= 10) {
			list.add((N / i) % 10);
		}
		
		Collections.sort(list,Comparator.reverseOrder());
		
		
		for(Integer i : list) {
			bw.write(i+"");
		}
		bw.flush();
		
		
	}

}

package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 단어_정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> list = new LinkedList<String>();
		
		for(int i = 0 ; i < n ; i++)
		{
			list.add(br.readLine());
		}
		
		Collections.sort(list,new Comparator<String>() {
			public int compare(String o1,String o2) {
				int value = o1.length() - o2.length();
			
				if(value != 0) 
				{
					return value;
				}
				
				return o1.compareTo(o2);
				
			}
		});
		
		Iterator<String> iter = list.iterator();
		String before = null;
		while(iter.hasNext())
		{
			String s = iter.next();
			if(!s.equals(before)) {
				bw.write(s+"\n");
			}
			before = s;
		
		}
		
		bw.flush();
		
	}

}


			// 24.8 // 24.9 // 25.1 // 25.2 //




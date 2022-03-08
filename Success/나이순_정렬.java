package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class 나이순_정렬  {
		static class User implements Comparable<User>{
			int age;
			String name;
			int index;
			public User(int a,String c) {
				age = a;
				name= c;
				index = idx;
			}
			
			public int compareTo(User o) {
				int a = age - o.age;
				
				if(a == 0) {
					return index - o.index;
				}
				else {
					return a;
				}
			}
			
		}
		static int idx = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String str[];
		List<User> list = new ArrayList<User>();
		
		for(int i = 0;i< n; i++) {
			str = br.readLine().split(" ");
			list.add(new User(Integer.parseInt(str[0]),str[1]));
			idx++;
		}
		
		Collections.sort(list);
		
		Iterator<User> iter = list.iterator();
		
		while(iter.hasNext()) {
			User c = iter.next();
			bw.write(c.age + " " + c.name +"\n" );
		}
		
		bw.flush();

	}

}

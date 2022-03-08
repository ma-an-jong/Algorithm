package Success;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 회사에_있는_사람 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String str[];
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i<n;i++)
		{
			str = br.readLine().split(" ");
			
			if(str[1].equals("enter"))
			{
				set.add(str[0]);
			}
			else
			{
				set.remove(str[0]);
			}
		}
		Iterator<String> iter = set.iterator();
		List<String> list = new LinkedList<String>();
		
		while(iter.hasNext())
		{
			list.add(iter.next());
		}
		
		Collections.sort(list,Collections.reverseOrder());
		iter = list.iterator();
		while(iter.hasNext())
		{
			bw.write(iter.next()+"\n");
		}
		
		bw.flush();

		
		
	}

}

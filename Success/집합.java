package À¶ÇÁÇÏ±â½È¾î;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class ÁýÇÕ {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		String str[];
		
		for(int i = 0 ; i < n ; i++) 
		{
			str = br.readLine().split(" ");
			
			if(str[0].equals("add")) 
			{
				try{
					set.add(Integer.parseInt(str[1]));
				}
				catch (Exception e) {
					
				}
			}
			else if(str[0].equals("remove"))
			{
				try {
					set.remove(Integer.parseInt(str[1]));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			else if(str[0].equals("check"))
			{
				if(set.contains(Integer.parseInt(str[1])))
				{
					bw.write("1\n");
				}
				else
				{
					bw.write("0\n");
				}
			}
			else if(str[0].equals("toggle"))
			{
				int value = Integer.parseInt(str[1]);
				if(set.contains(value))
				{
					set.remove(value);
				}
				else
				{
					set.add(value);
				}
			}
			else if(str[0].equals("all"))
			{
				set = new HashSet<Integer>();
				
				for(int k = 1; k <= 20; k++)
				{
					set.add(k);
				}
				
			}
			else
			{
				set = new HashSet<Integer>();
			}
				
			
			
		}
		
		bw.flush();
		
	}

}



package 융프하기싫어;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;


public class 이중_우선순위_큐 {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc;t++)
		{
			
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			int k = Integer.parseInt(br.readLine());
			String str[];
			for(int i =0 ; i < k ; i++)
			{
				str = br.readLine().split(" ");
				
				int tmp = Integer.parseInt(str[1]);
				
				if(str[0].equals("I"))
				{
					min.add(tmp);
					max.add(tmp);
					map.put(tmp, map.getOrDefault(tmp, 0)+1);
				}
				else
				{
					int value;
					
					if(tmp == 1)
					{
						try
						{
							while(true) {
								value = max.remove();
								int find = map.getOrDefault(value, 0);
								if(find == 0) 
								{
									continue;
								}
								else if(find == 1)
								{
									map.remove(value);
									break;
								}
								else 
								{
									map.put(value, map.getOrDefault(value, 0) - 1);
									break;
								}
							}
						}
						catch (Exception e) 
						{
							
						}
					}
					else
					{
						try
						{
							while(true) {
								value = min.remove();
								int find = map.getOrDefault(value, 0);
								if(find == 0) 
								{
									continue;
								}
								else if(find == 1)
								{
									map.remove(value);
									break;
								}
								else 
								{
									map.put(value, map.getOrDefault(value, 0) - 1);
									break;
								}
							}
						}
						catch (Exception e)
						{
							
						}
					}
					
				}
				
			}
		
		if(map.isEmpty())
		{
			bw.write("EMPTY\n");
			continue;
		}
			
		while(!max.isEmpty())
		{
			int a = max.remove();
			if(map.getOrDefault(a, 0) <= 0)
			{
				continue;
			}
			else
			{
				bw.write(a +" ");
				break;
			}
		}
		
		while(!min.isEmpty())
		{
			int a = min.remove();
			if(map.getOrDefault(a, 0) <= 0)
			{
				continue;
			}
			else
			{
				bw.write(a +"\n");
				break;
			}
		}
			
		}
		
		bw.flush();

	}
}

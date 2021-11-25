package À¶ÇÁÇÏ±â½È¾î;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ÃÖ´ë_Èü {
	
	public static void main(String[] args) throws Exception {
	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1,Integer o2)
			{
				return o2-o1;
			}
			
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int input;
		
		for(int i = 0 ; i < n; i++)
		{
			input = Integer.parseInt(br.readLine());
			
			if(input == 0)
			{
				try 
				{
					bw.write(pq.remove() +"\n");
				}
				catch (Exception e) {
					bw.write("0\n");
				}
				
			}
			else
			{
				pq.add(input);
			}
		}
		
		
		bw.flush();
		

	}

}

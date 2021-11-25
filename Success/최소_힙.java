package À¶ÇÁÇÏ±â½È¾î;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class ÃÖ¼Ò_Èü 
{
	public static void main(String args[]) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		int input;
		int output; 
		for(int i = 0 ; i < n; i++)
		{
			input = Integer.parseInt(br.readLine());
			
			if(input == 0)
			{
				try {
					output = pq.remove();
					bw.write(output+"\n");
				}
				catch (Exception e) 
				{
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

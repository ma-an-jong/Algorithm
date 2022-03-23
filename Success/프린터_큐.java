package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터_큐 {
	static class Doc{
		int id;
		int value;
		
		public Doc(int id,int value)
		{
			this.id = id;
			this.value = value;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < tc; t++)
		{
			String str[] = br.readLine().split(" ");
			
			int N = Integer.parseInt(str[0]);
			int target_id = Integer.parseInt(str[1]);
			
			Queue<Doc> q = new LinkedList<Doc>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			str= br.readLine().split(" ");
			for(int i = 0 ;i < N; i++)
			{
				int value = Integer.parseInt(str[i]);
				
				q.add(new Doc(i,value));
				pq.add(value);
				
			}

			Doc next;
			int cnt = 0;
			while(true)
			{
				next = q.remove();
				
				if(pq.peek() == next.value)
				{
					
					pq.remove();
					cnt++;
					
					if(next.id == target_id)
					{
						break;
					}
					
				}
				else
				{
					q.add(next);
				}

				
			}
			
			bw.write(cnt+"\n");
			
			
		}
			
		bw.flush();

	}

}

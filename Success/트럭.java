package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Æ®·° {
	
	static class Truck{
		int w;
		int remain;
		
		Truck(int w,int remain)
		{
			this.w = w;
			this.remain = remain;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		int L = Integer.parseInt(str[2]);
		
		str = br.readLine().split(" ");
		
		Queue<Truck> wait = new LinkedList<Truck>();

		
		for(int i = 0 ; i < n ; i++)
		{
			wait.add(new Truck(Integer.parseInt(str[i]),w));
		}
		
		Queue<Truck> bridge = new LinkedList<Truck>();
		
		int sum = 0;
		int count = 0;
		
		while(!wait.isEmpty())
		{
			
			Truck t = wait.peek();
			
			if(sum + t.w <= L && bridge.size() <= w)
			{
				wait.remove();
				bridge.add(t);
				sum+=t.w;
			}
			
			Iterator<Truck> iter = bridge.iterator();
			
			for( ; iter.hasNext() ;)
			{
				Truck nowTruck = iter.next();
				nowTruck.remain--;
			}

			if(!bridge.isEmpty() && bridge.peek().remain == 0)
			{
				Truck removed = bridge.remove();
				sum -= removed.w;
			}
			
			count++;
			
		}
		
		while(!bridge.isEmpty())
		{
			Iterator<Truck> iter = bridge.iterator();
			
			for( ; iter.hasNext() ;)
			{
				Truck nowTruck = iter.next();
				nowTruck.remain--;
			}
			
			if(bridge.peek().remain == 0)
			{
				Truck removed = bridge.remove();
				sum -= removed.w;
			}
			
			count++;
			
		}
		
		System.out.println(count+1);

	}

}

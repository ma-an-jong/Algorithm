package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

public class 회전하는_큐 {
	
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i = 1 ; i <= N ; i++)
		{
			dq.add(i);
		}
		
		int targets[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int value = 0;
		for(int i = 0; i < M ; i++)
		{
			int count = 0;
			for(int j = 0; j < dq.size();j++)
			{
				int x = dq.removeFirst();
				
				if(x == targets[i])
				{
					count = Math.min(count, (N-i) - count);
					value += count;
					break;
				}
				
				dq.addLast(x);
				count++;
						
			}

		}
		
		System.out.println(value);
		
	}
}

/*

static class Element{
		int id;
		int value;
		
		public Element(int id,int value)
		{
			this.id = id;
			this.value = value;
		}
		
		public void print()
		{
			System.out.print("("+id + " " + value+")");
		}
		
	}
	
	static class CircularDeQueue{
		Element data[] = new Element[55];
		int front = 0;
		int tail = 0;
		int size = 0;
		
		
		public void addFirst(Element e) throws Exception
		{
			if(size == data.length) throw new Exception();
			
		
			
			if(tail == front) 
			{
				tail++;
				tail %= data.length;
			}
			
			data[(front + data.length)%data.length] =  e;
			
			front--;
			front += data.length;
			front %= data.length;
			
			size++;
		}
		
		public void addLast(Element e) throws Exception
		{
			if(size == data.length) throw new Exception();
			
			if(tail == front) 
			{
				front--;
				front += data.length;
				front %= data.length;
			}
			
			data[(tail+data.length)%data.length] = e;
			tail++;
			tail %= data.length;
			size++;
			
		}
		
		public Element popFirst() throws Exception
		{
			if(size == 0) throw new Exception();
			
			front++;
			front %= data.length;
			
			Element e = data[front];
			data[front] = null;
			
			size--;
			
			return e;
		}
		
		public Element popLast() throws Exception
		{
			if(size == 0) throw new Exception();
			tail--;
			tail += data.length;
			tail %= data.length;
			
			Element e = data[tail];
			data[tail] = null;
			size--;
			
			return e;
		}
		
		public boolean isEmpty()
		{
			return size == 0;
		}
		
		public void print()
		
		{
			int cursor = (front+1)%data.length;
			
			for(int i = 0; i < size;i++)
			{
				data[cursor].print();
				cursor++;
				cursor %= data.length;
			}
			
			
		}
		
	}
	
*/
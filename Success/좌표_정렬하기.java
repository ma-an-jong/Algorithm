import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		
		public Pos(int a,int b) {	
			x =a;
			y =b;
		}
		
		public int compareTo(Pos o)
		{
			if(x == o.x)
			{
				return y - o.y;
			}
			else
			{
				return x - o.x;
			}
		}
		public String toString()
		{
			return x + " " + y + "\n";
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String str[];
		List<Pos> list = new LinkedList<Pos>();
		
		for(int i = 0; i < n;  i++) {
			str= br.readLine().split(" ");
			list.add(new Pos(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
			
		}
		
		Collections.sort(list);

		Iterator<Pos> iter = list.iterator();
		
		while(iter.hasNext())
		{
			bw.write(iter.next().toString());
		}
		bw.flush();
	
	}

}

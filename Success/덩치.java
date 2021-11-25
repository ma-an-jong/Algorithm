package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



class Person{
	int w;
	int h;
	
	public Person(int w,int h) {
		this.w = w;
		this.h = h;
	}
	
	public int compare(Person o) {
		if(this.w > o.w && this.h > o.h) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}

public class µ¢Ä¡ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Person p[] = new Person[N];
		int rank[] = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			String str[] = br.readLine().split(" ");
			p[i] = new Person(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		
		for(int i = 0 ; i < N ; i++) {
			
			int count = 0;
			
			for(int j = 0 ; j < N ; j++) {
				
				if(i == j) continue;
				
				if(p[j].compare(p[i]) > 0) {
					count++;
				}
				
			}
			
			rank[i] = count + 1;
		}

		
		for(int i = 0 ; i < N; i++) {
			bw.write(rank[i] + " ");
		}
		
		bw.flush();
	}

}

package D0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 에너지모으기 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void f(int w[] , int sum) {
		
		if(w.length == 2 ) {
			list.add(sum);
			return;
		}
		
		for(int i = 1; i < w.length -1 ; i++) {
			
			int a = w[i-1]*w[i+1];
			
			int w1[] = new int[w.length - 1];
			
			
			for(int j = 0 ; j < i ; j++) {
				w1[j] = w[j];
			}
			
			for(int j = i; j < w1.length;j++) {
				w1[j] = w[j+1];
			}
			
			f(w1, sum + a);
		
		}
	
	
	}
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		String str[] = br.readLine().split(" ");
		
		int w[] = new int[n];
		
		
		for(int i = 0 ; i < n ; i++) {
			w[i] = Integer.parseInt(str[i]);
		}
		
		f(w, 0);
		
		Collections.sort(list);
		Collections.reverse(list);
		
		
		
		System.out.println(list.get(0));
		
	}
}

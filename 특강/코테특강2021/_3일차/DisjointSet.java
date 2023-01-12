package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DisjointSet {
	public static int findset(int data[],int p) {
		if(p == data[p])
			return p;
		data[p] = findset(data, data[p]);
		return data[p];
	}
	
	public static void unionset(int data[],int a,int b) {
		int ap = findset(data, a);
		int bp = findset(data, b);
		data[ap] = bp; 
	}
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int data[] = new int[n+1];
		
		for(int  i = 1 ; i < data.length;i++) {
			data[i] = i;
		}
		
		for(int i = 0 ; i < m;i++) {
			str = br.readLine().split(" ");
			
			if(Integer.parseInt(str[0]) == 0) {
				unionset(data, Integer.parseInt(str[1]),Integer.parseInt(str[2]));
			}
			
			else if(Integer.parseInt(str[0]) == 1) {
				int a = findset(data,Integer.parseInt(str[1]));
				int b = findset(data,Integer.parseInt(str[2]));
				
				if(a == b) {
					bw.write("YES\n");
				}
				else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
	}
}

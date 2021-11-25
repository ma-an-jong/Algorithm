package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 模备_匙飘况农 {
	
public static int find(int[] arr,int index) {
		
		if(arr[index] == index) {
			return index;
		}
		
		else {
			arr[index] = find(arr,arr[index]);
			return arr[index];
		}
		
	}
	
	public static boolean union(int[] arr,int a,int b) {
		if(find(arr,a) == find(arr,b)) {
			return false;
		}
		else {
			arr[find(arr,a)] = find(arr,b);
			return true;
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			String str[];
			
			int arr[] = new int[200000];
			int child[] = new int[200000];
			
			for(int i = 0; i < 200000 ; i++) {
				arr[i] = i;
				child[i] = 1;
			}
			
			for(int i = 0 ; i < n ; i++) {
				str = br.readLine().split(" ");
				
				int lvalue;
				int rvalue;
				
				try {
					lvalue = map.get(str[0]);
				}
				catch(NullPointerException e) {
					lvalue = map.size();
					map.put(str[0], lvalue);
					
				}
				
				try {
					rvalue = map.get(str[1]);
				}
				catch(NullPointerException e) {
					rvalue = map.size();
					map.put(str[1], rvalue);
					
				}
				int l = find(arr,lvalue);
				int r =  find(arr,rvalue);
				
			if( l != r) {
				union(arr, lvalue, rvalue);
				child[r] += child[l];
				bw.write(child[r] + "\n");
			}
			else {
				bw.write(child[r] + "\n");
			}

		}
			
			bw.flush();
		
	}
	
		bw.close();
		br.close();

		
	}
}

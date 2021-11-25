package D0830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구간합구하기 {
	public static void setData(int[] tree,int idx , int val) {
			val = val - tree[idx];
			
			while(idx != 0) {
			tree[idx] += val;
			idx /=2;
			}
	}
	
	public static int segTree(int tree[] , int idx , int cl, int cr , int left, int right) {
		if(left <= cl && cr <= right) 
			return tree[idx];
		if(cr < left) return 0;
		if(cl > right) return 0;
		
		int v1 = segTree(tree,idx * 2, cl, (cl+cr)/2, left, right);
		int v2 = segTree(tree,idx * 2 + 1, (cl+cr)/2 + 1, cr, left, right);
		
		return v1 + v2;
				
	}
	
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
	
		int tree[] = new int[1000001];
		
		
		
//		for(int i = 1 ; i<= n ;i++) {
//			int x = Integer.parseInt(br.readLine());
//			
//			int index = 1;
//			
//			while(true) {
//				if(tree[index] == 0) {
//					tree[index] = x;
//					break;
//				}
//				
//				if(tree[index] < x) {
//					index = 2*index + 1;
//				}
//				else if(tree[index] > x) {
//					index = 2*index;
//				}
//			}
//		}
		
		int start = 1;
		while(start < n) {
			start *= 2;
		}
		
		for(int i = start ; i < start + n;i++ ) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		setData(tree,start,tree[start]);
		
		for(int i = 0 ; i < m+k;i++) {
			str = br.readLine().split(" ");
		
			if(str[0].equals("1")) {
				int index = Integer.parseInt(str[1]);
				int value = Integer.parseInt(str[2]);
				setData(tree, index, value);
			}
			else {
				int result = segTree(tree, 1,Integer.parseInt(str[1]) ,Integer.parseInt(str[2]) ,start , 2*start - 1 );
				bw.write(result+"\n");
			}
		}
		
		bw.flush();
		
	}
}

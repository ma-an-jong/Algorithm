package D1031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Tower{
	int index;
	int x;
	int y;
	int r;
	
	Tower(int index,String x,String y,String r){
		this.index = index;
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.r = Integer.parseInt(r);
	}
	
	public double distance(Tower o) {
		return Math.sqrt(Math.pow(this.x-o.x,2) + Math.pow(this.y-o.y,2)); 
	}
}


public class Count_Circle_Groups {
	
	
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
		
		for(int t = 0 ; t < T ; t++) {

			int n = Integer.parseInt(br.readLine());
			
			Tower tower[] = new Tower[n];
			
			String str[];
			int arr[] = new int[n];
			
			for(int i = 0 ; i < n ; i ++)
			{	
				arr[i] = i;
				str = br.readLine().split(" ");
				tower[i] = new Tower(i, str[0], str[1], str[2]);
			}
			
			
			for(int i = 0 ; i < n;i++) {
				for(int j = 0 ; j < n;j++) {
					if(i == j) continue;
					
					if(tower[i].distance(tower[j]) <= tower[i].r + tower[j].r) {
						union(arr, i, j);
					}
					
				}
			}
			int count = 0;
			for(int i = 0 ; i < n;i++) {
				if(arr[i] == i) {
					count++;
				}
			}
			
			bw.write(count +"\n");
				
		}
		bw.flush();
	}
}

package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Merge {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		
		int arr[] = new int[size];
		
		for(int i = 0; i < size;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(arr, 0, size - 1);
		
		for(int i = 0; i < arr.length;i++) {
			bw.write(arr[i]+"\n")	public static void sort(int arr[],int left,int right) {
				int tmp[] = new int[right-left + 1];
				
				if(left == right) {
					return ;
				}
				
				int mid = (left + right)/2;
				sort(arr,left,mid);
				sort(arr,mid+1,right);
				
				int leftidx = left;
				int rightidx = mid + 1;
				int tmpidx = 0;
				
				
				while(leftidx <= mid && rightidx <= right) {
					if(arr[leftidx] <= arr[rightidx]) {
						tmp[tmpidx] = arr[leftidx];
						leftidx++;
						tmpidx++;
					}
					else 
					{
						tmp[tmpidx] = arr[rightidx];
						rightidx++;
						tmpidx++;
					}
				}
				
				while(leftidx <= mid) {
					tmp[tmpidx] = arr[leftidx];
					leftidx++;
					tmpidx++;
				}
				
				while(rightidx <= right) {
					tmp[tmpidx] = arr[rightidx];
					rightidx++;
					tmpidx++;
				}
				
				for(int i = 0; i < tmpidx;i++) {
					arr[left + i] = tmp[i];
				}	
			};
		}
		
			bw.flush();
		
	}
	
	

}

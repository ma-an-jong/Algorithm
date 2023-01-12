package D0823;

public class Quick {
	
	public static void main(String args[]) {
		int arr[] = { 9,5,1,7,3,4,6,8,9,2 }; 
		sort(arr, 0, 9);
		
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
	public static void sort(int[] arr, int l,int r) {
		int left = l;
		int right = r;
		
		int pivot = arr[((l+r)/2)];
		
		while(left <= right) {
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			if(left <= right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				
				left++; right--;
			}
		}
		
		if(l < right) sort(arr,l,right);
		if(r > left ) sort(arr,left,r);
		
		
		
	}
}

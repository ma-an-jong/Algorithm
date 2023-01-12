package D0823;


//recursion base
public class Main {
	public static void main(String[] args) {
		new Main().method(0,10);
	}
	
	int arr[] = new int[10];
	
	public void method(int depth , int n) {
		if(depth == n) {
			for(int i = 0; i < n ; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return ;
		}
		for(int i = 0; i < 3; i++) {
			arr[depth] = i;
			method(depth + 1,n);
		}
	}	
}

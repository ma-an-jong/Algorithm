package D0830;

public class 이진트리배열 {
	public static void main(String args[]) {
		
		int tree[] = new int[1000];
		
		
		String input = "9 7 6 3 2 5 20 10";
		
		String str[] = input.split(" ");
		
		
		for(int i = 1 ; i<= str.length ;i++) {
			int x = Integer.parseInt(str[i-1]);
			
			int index = 1;
			
			while(true) {
				if(tree[index] == 0) {
					tree[index] = x;
					break;
				}
				
				if(tree[index] < x) {
					index = 2*index + 1;
				}
				else if(tree[index] > x) {
					index = 2*index;
				}
			}
			
			
		}
		
		
		for(int i = 1 ; i < tree.length;i++) {
			System.out.print(tree[i] + " ");
		}
		
	}

}

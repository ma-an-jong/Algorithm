package Success;
import java.util.Scanner;

public class ºÐÇØÇÕ {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		boolean flag = true;
		for(int i = 0; i < N ; i++) {
			int sum = i;
			
			for(int j = 1; j < i; j *= 10) {
				sum+= i/j % 10;
			}
			
			if(sum == N) 
			{
				System.out.println(i);
				flag = false;
				break;
			}
			
		}
		
		if(flag) System.out.println(0);
	}
}

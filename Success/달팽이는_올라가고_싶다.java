package Success;

import java.util.Scanner;

public class 달팽이는_올라가고_싶다 {
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		double v = s.nextDouble();
		
		System.out.println((int)Math.ceil((v-a)/(a-b) + 1));
		
		
		
	}
}

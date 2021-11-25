package D0823;

import java.util.Scanner;

public class B7567 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		B7567 c = new B7567();
		
		String s = scanner.next();
		
		System.out.println(c.plate(s));
			
	}
	
	public int plate(String s) {
		int length = 0;
		
		if(s.length() ==0 )
			return length;
		else length = 10;
		
		for(int i = 1; i < s.length(); i++) {
			
			if(s.charAt(i) == s.charAt(i-1)) 
				length = length + 5;
			else 
				length = length + 10;	
		}	
		return length;	
	}
	
}

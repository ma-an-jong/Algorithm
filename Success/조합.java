package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class а╤гу {
	
	public static BigInteger foo(int a,int count) 
	{
		if(count == 0) {return new BigInteger("1");}
		return foo(a-1,count-1).multiply(new BigInteger(String.valueOf(a)));
	}
	
	static int n;
	static int m;
	
	public static void main(String args[]) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		String str[] = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		BigInteger a = foo(n,m);
		BigInteger b = foo(m,m);
		System.out.println(a.divide(b));
		
	}

}




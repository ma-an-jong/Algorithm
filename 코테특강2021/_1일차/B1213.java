package D0823;

import java.io.*;

//¸ð¸£°Ú
public class B1213 {
	public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] a = new int[26];
		for(int i=0; i<s.length(); i++) {
			a[s.charAt(i)-'A']++;
		}
		int midIdx = 0;
		boolean flag = false;
		for(int i=0; i<a.length; i++) {
			if(a[i]%2!=0) {
				midIdx = i;
				flag = true;
			}
		}
		
		if((s.length()%2!=0 && flag) || (s.length()%2==0 && flag)) {
			System.out.print("I'm Sorry Hansoo");
		} else {
			String ans = "";
			for(int i=0; i<a.length; i++) {
				for(int j=0; j<a[i]/2; j++) {
					ans += ((char)(i+'A'));
				}
			}
			String rev = reverseString(ans);
			if(odd==1) ans += ((char)(midIdx+'A'));
			System.out.print(ans+rev);
		}
	}
}

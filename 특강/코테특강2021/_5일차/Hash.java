package _5일차;

public class Hash {
	public static void main(String args[]) {
		
		String str = "라빈-카프 알고리즘은 문자열에 해싱 기법을 사용하여 해시 값으로 비교하는 알고리즘입니다."
				+ " 간단하게 해시 값을 만들려면 문자열의 각 문자(ASCII TABLE 값)에 특정 수의 제곱 수를 차례대로 곱하여 모두 더하면 됩니다."
				+ " 이러한 방식을 사용하면 두 문자열이 서로 다를 때 두 문자열의 해시 값이 다르게 나오게 됩니다.";
		
		String string = "문자열에";
		
		int hk = 17;
		int hm = 28657;
		int hk4 = 1;
		
		int ans = 0;
		int ans1 = 0;
		
			for(int j = 0; j < 4;j++) {
			 ans *= hk;
			 ans1 *= hk;
			 ans += str.charAt(j);
			 ans1 += string.charAt(j);
			 ans %= hm;
			 ans1 %= hm;
			 hk4 *= hk;
			 hk4 %= hm;
			}
			

		System.out.println("ans:" + ans);
		System.out.println("ans1" + ans1);
		
		for(int i = 4; i < str.length() ;i++) {
			ans *= hk;
			ans -= (str.charAt(i-4)*hk4)%hm;
			ans += str.charAt(i);
			ans += hm;
			ans %= hm;
			System.out.println( i + "ans:" + ans);
			
			if(ans == ans1) {
				System.out.println(str.charAt(i-3) +"" +str.charAt(i-2) +"" + str.charAt(i-1) +"" +str.charAt(i) +"");
				System.out.println(ans + "zzzzzzzzzzzz");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

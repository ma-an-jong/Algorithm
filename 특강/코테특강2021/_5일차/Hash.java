package _5����;

public class Hash {
	public static void main(String args[]) {
		
		String str = "���-ī�� �˰����� ���ڿ��� �ؽ� ����� ����Ͽ� �ؽ� ������ ���ϴ� �˰����Դϴ�."
				+ " �����ϰ� �ؽ� ���� ������� ���ڿ��� �� ����(ASCII TABLE ��)�� Ư�� ���� ���� ���� ���ʴ�� ���Ͽ� ��� ���ϸ� �˴ϴ�."
				+ " �̷��� ����� ����ϸ� �� ���ڿ��� ���� �ٸ� �� �� ���ڿ��� �ؽ� ���� �ٸ��� ������ �˴ϴ�.";
		
		String string = "���ڿ���";
		
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

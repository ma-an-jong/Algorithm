package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class µ¿Àü_0 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		int arr[] = new int[N];
		
		for(int i = 0 ; i < N ; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int value = 0;
		int cursor = N-1;
		int cnt = 0;
		
		while(value != K)
		{
			if(value + arr[cursor] > K)
			{
				cursor--;
			}
			else
			{
				cnt++;
				value+= arr[cursor];
			}
		}
		
		System.out.println(cnt);
		
		
	}

}

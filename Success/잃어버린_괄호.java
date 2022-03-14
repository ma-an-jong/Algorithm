package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ÀÒ¾î¹ö¸°_°ýÈ£ {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		String sums[] = str.split("\\-");
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < sums.length;i++)
		{
			String tmp[] = sums[i].split("\\+");
			int value = 0;
			
			for(int j = 0 ; j < tmp.length;j++)
			{
				int x = Integer.parseInt(tmp[j]);
				value += x;
			}
			list.add(value);
			
		}
		
		int ans = list.get(0);
		
		for(int i = 1; i < list.size(); i++)
		{
			ans -= list.get(i);
		}
		
		System.out.println(ans);

	
	}

}

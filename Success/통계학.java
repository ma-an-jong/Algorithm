package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ≈Î∞Ë«– {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
	
		int arr[] = new int[N];
		int bucket[] = new int[8001];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N ; i++)
		{
			int num = Integer.parseInt(br.readLine());
			bucket[num+4000]++;
			
			if(bucket[num+4000] > max)
				max= bucket[4000+num];
		}
		
		int index = 0;
		int cursor = 0;
		
		while(cursor < N)
		{
			for( int i = cursor ; i < cursor + bucket[index]; i++)
			{
				arr[i] = index - 4000;
			}
			
			cursor += bucket[index];
			index++;
			
		}
		
		int sum = 0;
		
		for(int i = 0 ; i < N ; i++)
		{		
			sum += arr[i];
		}
		
		int ans1 = (int)Math.round(((double)sum/(double)N));
		
		int ans2 = arr[N/2];
		
		
		int ans3 = 0;
		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i< bucket.length;i++) {
			if(max == bucket[i]) 
			{
				list.add(i-4000);
				cnt++;
			}
		}
		Collections.sort(list);
		
		ans3 = cnt == 1 ? list.get(0) : list.get(1);
		
		int ans4 = arr[N-1] -arr[0]; 
		
		bw.write(ans1 + "\n");
		bw.write(ans2 + "\n");
		bw.write(ans3 + "\n");
		bw.write(ans4 + "\n");
		bw.flush();
	}

}

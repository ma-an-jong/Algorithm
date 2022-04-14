package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소셜_네트워킹_어플리케이션 {
	
	public static int data[];
	public static int find(int j) 
	{
		if(data[j] == j)
		{
			return j;
		}
		
		data[j] = find(data[j]);
		
		return data[j];
	}
	
	public static void union(int i , int j)
	{
		int ip = find(i);
		int jp = find(j);
		
		if(ip != jp)
		{
			data[ip] = jp; 
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0 ; tc<T ;tc++) 
		{
			
			sb.append("Scenario " + (tc + 1)+ ":\n");
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			data = new int[n+1];
			for(int i = 0; i <=n;i++)
			{
				data[i] = i;
			}
			
			for(int i = 0; i < k;i++)
			{
				String str[] = br.readLine().split(" ");
				union(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			}
			
			int m = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i < m ; i++)
			{
				String str[] = br.readLine().split(" ");
				
				if(find(Integer.parseInt(str[0])) == find(Integer.parseInt(str[1]))) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
				
			}
			if (tc < T-1) sb.append("\n");
			
		}
		
		System.out.print(sb);
		

	}

}

package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ≈Õ∑ø {
	
	public static class Turret{
		int x;
		int y;
		int r;
		
		public Turret(int x,int y,int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}
	public static void main(String args[]) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<tc;t++) 
		{
			String str[] = br.readLine().split(" ");
			
			Turret a = new Turret(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			Turret b = new Turret(Integer.parseInt(str[3]), Integer.parseInt(str[4]), Integer.parseInt(str[5]));
			if(a.x == b.x && a.y == b.y && a.r == b.r) 
			{
				sb.append("-1\n");
				continue;
			}
			double squaredDistance = Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2); 
			double distance = Math.sqrt(squaredDistance);
			
			if(distance > a.r+b.r || distance + Math.min(a.r,b.r) < Math.max(a.r,b.r))
			{
				sb.append("0\n");
			}
			else if(distance == a.r+b.r || distance + Math.min(a.r,b.r) == Math.max(a.r,b.r))
			{
				sb.append("1\n");
			}
			else
			{
				sb.append("2\n");
			}
		
		}
		
		System.out.println(sb);
		
	}
}

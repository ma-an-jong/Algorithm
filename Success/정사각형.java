package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정사각형 {
	public static class Dot {
		int x;
		int y;
		
		Dot(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < tc;t++)
		{
			String str[];
			Dot dots[] = new Dot[4];
			
			for(int i = 0 ; i < 4; i++)
			{
				str = br.readLine().split(" ");
				dots[i] = new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			}
			
			
			double arr[] = new double[6];
			int index= 0;
			
			for(int i = 0 ; i < 4;i++) {
				for(int j = i+1;j<4;j++) {
					Double distance= Math.pow((dots[i].x - dots[j].x),2) + Math.pow((dots[i].y - dots[j].y),2);
					arr[index++] = distance;
				}
			}
			
			Arrays.sort(arr);

			if(arr[0] == arr[1] &&
				arr[1] == arr[2] &&
				arr[2] == arr[3] &&
				arr[4] == arr[5]) 
			{
				sb.append(1+"\n");
			}
			else sb.append(0+"\n");
		}
		
		System.out.println(sb);
		
	}

}

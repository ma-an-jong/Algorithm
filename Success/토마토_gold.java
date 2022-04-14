package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ≈‰∏∂≈‰_gold {
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		
		int X = Integer.parseInt(str[0]);
		int Y = Integer.parseInt(str[1]);
		int Z = Integer.parseInt(str[2]);
		
		
		int data[][][] = new int[Z][Y][X];
		int isvisited[][][] = new int[Z][Y][X];
		
		for(int i = 0; i < Z;i++)
		{
			for(int j = 0 ; j < Y;j++)
			{		
				str = br.readLine().split(" ");
				for(int k = 0; k < X ; k++)
				{
					data[i][j][k] = Integer.parseInt(str[k]);
				}
			}
		}
		
		boolean flag = true;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qz = new LinkedList<Integer>();
		
		for(int i = 0; i < Z;i++)
		{
			for(int j = 0 ; j < Y;j++)
			{		
				for(int k = 0; k < X ; k++)
				{
					
					if(data[i][j][k] == 1)
					{
						qx.add(k);
						qy.add(j);
						qz.add(i);
					}
					else if(data[i][j][k] == 0)
					{
						flag = false;
					}
					
				}
			}
		}
		
		if(flag) 
		{
			System.out.println("0");
			return;
		}
		
		int dx[] = {1,0,-1,0,0,0};
		int dy[] = {0,1,0,-1,0,0};
		int dz[] = {0,0,0,0,1,-1};
		
		while(true) 
		{
			if(qx.isEmpty()) break;
			
			int x = qx.remove();
			int y = qy.remove();
			int z = qz.remove();
			
			
			for(int i = 0; i < 6;i++)
			{
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				try 
				{
					if(data[nz][ny][nx] == 0 && isvisited[nz][ny][nx] == 0)
					{
						qx.add(nx);
						qy.add(ny);
						qz.add(nz);
						data[nz][ny][nx] = 1;
						isvisited[nz][ny][nx] = isvisited[z][y][x]+1;
					}
					
				}
				catch (Exception e) 
				{
					continue;
				}
				
			}
		}
		
		int ans = 0;
		
		for(int i = 0; i <Z ;i++)
		{
			for(int j = 0 ; j < Y;j++)
			{		
				for(int k = 0; k < X ; k++)
				{
					if(data[i][j][k] == 0)
					{
						System.out.println("-1");
						return;
					}
					else
					{
						ans = Math.max(ans,isvisited[i][j][k]);
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}

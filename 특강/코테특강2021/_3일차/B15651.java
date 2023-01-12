package D0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B15651 {
	public static void subset(int ans[],int visited[],int depth, int n,ArrayList<String> list,int cnt,int m) 
			throws Exception{
				if (depth == n) {
					if (cnt == m) {
						String sb = "";
						for (int i = 0; i < n; i++) {
							if (visited[i] == 1)
								 sb = sb + (ans[i] + 1)+ " ";
						}
						sb = sb + "\n";
						list.add(sb);
					}
					return;
				}

				visited[depth] = 0;
				subset(ans,visited,depth + 1, n,list,cnt,m);
				visited[depth] = 1;
				subset(ans,visited,depth + 1, n,list,cnt+1,m);
				
			}
	public static void main(String args[]) throws Exception{
		
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		
		int ans[] = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			ans[i] = i;
		}
		
		int visited[] = new int[n + 1];
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		subset(ans, visited, 0, n, list, 0, m);
		
		Collections.reverse(list);
		

		for(int i = 0; i < list.size();i++) {
			bw.write(list.get(i));
		}
		
		bw.flush();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

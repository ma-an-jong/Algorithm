package D0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B17298 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<Integer>();

		Stack<Integer> s1 = new Stack<Integer>();

		int arr[] = new int[n];

		String str[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			s.push(Integer.parseInt(str[i]));
		}

		for (int i = n - 1; i >= 0; i--) {
			int a = s.pop();

			while (true) {
				if (s1.isEmpty()) 
					{
						arr[i] = -1;
						s1.push(a);
						break;
					} 
				else 
					{
					if (s1.peek() > a) 
						{
							arr[i] = s1.peek();
							s1.push(a);
							break;
						} 
					else 
						{
							s1.pop();
						}
					}

			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			bw.write(arr[i] +" ");
		}
		bw.flush();
		
	}
}

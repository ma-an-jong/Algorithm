package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Ω∫≈√ {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int n = Integer.parseInt(br.readLine());
		
		String str[];
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				s.push(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("pop")){
				try {
					bw.write(s.pop() +"\n");
				}
				catch (Exception e) {
					bw.write("-1\n");
				}
			}
			else if(str[0].equals("size")){
				bw.write(s.size() +"\n");
			}
			else if(str[0].equals("empty")){
				int flag = s.empty() ? 1 : 0;
				bw.write(flag +"\n");
			}
			else if(str[0].equals("top")){
				try {
					bw.write(s.peek()+"\n");
				}
				catch (Exception e) {
					bw.write("-1\n");
				}
			}
			
		}
		
		bw.flush();
	}

}


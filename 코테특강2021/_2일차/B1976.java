package D0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1976 {

	public static int findset(int data[], int p) {
		if (p == data[p])
			return p;
		data[p] = findset(data, data[p]);
		return data[p];
	}

	public static void unionset(int data[], int a, int b) {
		int ap = findset(data, a);
		int bp = findset(data, b);
		data[ap] = bp;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		String str[];

		int data[] = new int[n+1];

		for (int i = 1; i <= n; i++) {
			data[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			str = br.readLine().split(" ");

			for (int j = 1; j <= n; j++) {
				if (str[j-1].equals("1")) {
					unionset(data,i,j);
				}
			}
		}

		str = br.readLine().split(" ");
		
		boolean flag = false;		
		
		for(int i = 0; i < str.length-1;i++) {
			if(findset(data, Integer.parseInt(str[i])) != findset(data, Integer.parseInt(str[i+1])) ) {
				flag = true;
			}
		}
		
		if(flag) {
			bw.write("NO");
		}
		else {
			bw.write("YES");
		}
		bw.flush();
	}
}

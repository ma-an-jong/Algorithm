package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class AC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			str = n > 0 ? str.substring(1, str.length() - 1) : "";

			String arr[] = str.split(",");

			Deque<Integer> dq = new ArrayDeque<Integer>();
			str = null;
			for (int i = 0; i < n; i++) {
				dq.add(Integer.parseInt(arr[i]));
			}

			boolean isReverse = false;
			boolean flag = true;

			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					isReverse = !isReverse;
				} else {

					if (isReverse) {
						if (dq.isEmpty()) {
							flag = false;
							break;
						}

						dq.removeLast();
					} else {
						if (dq.isEmpty()) {
							flag = false;
							break;
						}

						dq.removeFirst();
					}
				}

			}

			if (flag) {

				bw.write("[");
				Iterator<Integer> iter;
				if (isReverse) {
					iter = dq.descendingIterator();
				} else {
					iter = dq.iterator();
				}

				if (!dq.isEmpty()) {
					int x = iter.next();
					for (; iter.hasNext(); x = iter.next()) {
						bw.write(x + ",");
					}
					bw.write(x + "]\n");
				} else {
					bw.write("]\n");
				}

			} else {
				bw.write("error\n");
			}

		}
		bw.flush();

	}

}

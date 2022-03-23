package Success;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class µ¦ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String str[];
		Deque<Integer> dq = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");

			if (str[0].equals("push_front")) {
				dq.addFirst(Integer.parseInt(str[1]));
			} else if (str[0].equals("push_back")) {
				dq.addLast(Integer.parseInt(str[1]));
			} else if (str[0].equals("pop_front")) {
				if (dq.size() == 0) {
					bw.write("-1\n");
				} else {
					bw.write(dq.pollFirst() + "\n");
				}
			} else if (str[0].equals("pop_back")) {
				if (dq.size() == 0) {
					bw.write("-1\n");
				} else {
					bw.write(dq.pollLast() + "\n");
				}
			} else if (str[0].equals("size")) {
				bw.write(dq.size() + "\n");
			} else if (str[0].equals("empty")) {
				if (dq.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (str[0].equals("front")) {
				if (dq.size() == 0) {
					bw.write("-1\n");
				} else {
					bw.write(dq.peekFirst() + "\n");
				}
			} else if (str[0].equals("back")) {
				if (dq.size() == 0) {
					bw.write("-1\n");
				} else {
					bw.write(dq.peekLast() + "\n");
				}
			}

		}

		bw.flush();

	}

}

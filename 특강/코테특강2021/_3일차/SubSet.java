package D0825;

public class SubSet {
	static int data[] = { 5, 12, 13, 15, 30 };
	static int visited[] = new int[data.length];

	public static void subset(int depth, int n, int cnt) {
		if (depth == n) {
			if (cnt == 3) {
				for (int i = 0; i < n; i++) {
					if (visited[i] == 1)
						System.out.print(data[i] + " ");
				}
				System.out.println();
			}
			return;
		}

		visited[depth] = 0;
		subset(depth + 1, n,cnt);
		visited[depth] = 1;
		subset(depth + 1, n,cnt+1);
	}

	public static void main(String args[]) {
		subset(0,5,0);
	}
}

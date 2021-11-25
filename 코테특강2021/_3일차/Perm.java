package D0825;

public class Perm {

	static int data[] = { 5, 12, 13, 15, 30 };
	static int visited[] = new int[data.length];
	static int ans[] = { 1, 2, 3, 4, 5 };

	public static void perm(int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {

			if (visited[i] == 0) {
				visited[i] = 1;
				ans[depth] = data[i];
				perm(depth + 1, n, r);
				visited[i] = 0;
			}
		}
	}

	public static void main(String args[]) {

		perm(0, 5, 3);

	}
}

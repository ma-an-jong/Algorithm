package Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ¡÷¿Øº“ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dist = new int[N - 1];
		int[] cost = new int[N];
		
		String str[] = br.readLine().split(" ");
		
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(str[i]);
		}

		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(str[i]);
		}

		long sum = 0;
		long minCost = cost[0];

		for (int i = 0; i < N - 1; i++) {

			if (cost[i] < minCost) {
				minCost = cost[i];
			}

			sum += (minCost * dist[i]);
		}

		System.out.println(sum);

	}
}

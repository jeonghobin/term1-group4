package month3.day01.과제;

import java.io.*;
import java.util.*;

public class 창용마을 {

	static int[] parents;
	static int answer;
	static int N;
	static int M;

	static int[][] adj;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람 수
			M = Integer.parseInt(st.nextToken()); // 관계 수

			v = new boolean[N + 1];
			adj = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adj[a][b] = 1;
				adj[b][a] = 1;
			}
			answer = 0;
			for (int i = 1; i < N + 1; i++) {
				if (v[i] == false) {
//					bfs(i);					
					dfs(i);
					answer++;

				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void dfs(int idx) {
		v[idx] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!v[i] && adj[idx][i] == 1) {
				dfs(i);
			}
		}
	}

	private static void bfs(int idx) {
		v[idx] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);

		while (!q.isEmpty()) {
			Integer p = q.poll();

			for (int i = 1; i < N + 1; i++) {
				if (!v[i] && adj[p][i] == 1) {
					v[i] = true;
					q.offer(i);
				}
			}

		}

	}
}
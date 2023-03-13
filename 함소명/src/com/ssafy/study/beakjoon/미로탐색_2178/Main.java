package com.ssafy.study.beakjoon.미로탐색_2178;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] miro;
	static int depth;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}

		BFS();
	}

	private static void BFS() {
		Queue<int[]> Q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		Q.offer(new int[] { 0, 0, 1 });
		v[0][0] = true;

		while (!Q.isEmpty()) {
			int[] p = Q.poll();
			depth = p[2];
			if (p[0] == N - 1 && p[1] == M - 1)
				break;

			for (int i = 0; i < 4; i++) {
				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && miro[nr][nc] == 1 && !v[nr][nc]) {
					v[nr][nc] = true;
					Q.offer(new int[] { nr, nc, p[2] + 1 });
				}
			}
		}

		System.out.println(depth);
	}

}

package com.ssafy.study.beakjoon.beak_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 알파벳
 * (1행 1열) 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.말이 최대한 몇 칸을 지날 수 있는지? - DFS
 */
public class Main {
	static int R;
	static int C;
	static int max = Integer.MIN_VALUE;
	static char[][] map;
	static boolean[] v = new boolean[26];

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

//		DFS(0, 0, 1);
		DFS(0, 0);

		System.out.println(cnt);
	}


	static int cnt;
	private static void DFS(int r, int c) {
		Stack<Position> stack = new Stack<>();
		stack.push(new Position(r, c));
		v[map[r][c] - 'A'] = true;
		cnt++;

		while (!stack.isEmpty()) {
			System.out.println(stack);
			Position Alpa = stack.pop();
			
			for (int i = 0; i < 4; i++) {
				int dx = Alpa.r + dr[i];
				int dy = Alpa.c + dc[i];

				if (dx >= 0 && dx < R && dy >= 0 && dy < C && !v[map[dx][dy] - 'A']) {
					v[map[dx][dy] - 'A'] = true;
					stack.push(new Position(dx, dy));
					cnt++;
				}
				
			}
			
		}
	}

	private static void DFS(int r, int c, int k) {
		
		max = Math.max(max, k);
		v[map[r][c] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];

			if (dx >= 0 && dx < R && dy >= 0 && dy < C && !v[map[dx][dy] - 'A']) {
				DFS(dx, dy, k + 1);
			}
		}
		
		v[map[r][c] - 'A'] = false;
	}

}

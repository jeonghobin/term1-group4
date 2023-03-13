package com.ssafy.study.swea;

import java.io.*;
import java.util.*;

public class 프로세서연결하기_Re {
	static int N, min;
	static int[][] map;
	static List<Point> list;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if ((i > 0 && i < N - 1) && (j > 0 && j < N - 1) && map[i][j] == 1)
						list.add(new Point(i, j));
				}
			}

			// Core가 최대로 연결되어야하므로 최대 연결 할 수 있는 것부터 줄여간다.
			for (int i = list.size(); i >= 0; i--) {
				combination(0, new boolean[list.size()], 0, i);
				if (min < Integer.MAX_VALUE)
					break; // 최솟값이 갱신되어 있으면 결과가 나왔다는 뜻임
			}

			System.out.println("#" + test_case + " " + min);
		}

	}

	// M개 중 M개를 뽑는 조합부터 시작
	public static void combination(int idx, boolean chk[], int cnt, int R) {
		if (cnt == R) {
			dfs(0, 0, chk);
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			chk[i] = true;
			combination(i + 1, chk, cnt + 1, R);
			chk[i] = false;
		}
	}

	private static void dfs(int idx, int cnt, boolean[] chek) {
		if (idx == list.size()) {// 끝까지 돌렸을때 최솟값 갱신.
			min = Math.min(min, cnt);
			return;
		}
		// 부분 집합에 포함되는 애들만 다음 단계로 넘어갈 수 있다
		if (!chek[idx]) {
			dfs(idx + 1, cnt, chek);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = list.get(idx).r, y = list.get(idx).c, tmp = 0;
			boolean success = false;
			while (true) {
				x += dr[i];
				y += dc[i];
				if (x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 갔으면 성공
					success = true;
					break;
				}
				if (map[x][y] != 0)
					break; // 전선이나 코어를 만나면 실패
				map[x][y] = 2; // 전선 표시
				tmp++; // 전선 길이 합

				for (int j = 0; j < N; j++) {
					for (int j2 = 0; j2 < N; j2++) {
						System.out.print(map[j][j2] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			if (success)
				dfs(idx + 1, cnt + tmp, chek);
			while (true) { // 원 상태로 돌려놓기
				x -= dr[i];
				y -= dc[i];
				if (x == list.get(idx).r && y == list.get(idx).c)
					break;
				map[x][y] = 0;
			}
		}
	}

}

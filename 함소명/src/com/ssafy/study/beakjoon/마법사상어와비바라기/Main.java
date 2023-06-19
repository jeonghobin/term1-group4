package com.ssafy.study.beakjoon.마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//마법사 상어와 비바라기
public class Main {
	static int N, M;
	static int[][] water;
	// x,왼,위왼,위,위오,오,오아,아,왼아
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<Point> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		water = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 구름의 위치
		Q = new LinkedList<>();
		Q.add(new Point(N - 2, 0));
		Q.add(new Point(N - 2, 1));
		Q.add(new Point(N - 1, 0));
		Q.add(new Point(N - 1, 1));
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			move(d, s);
		}
		
		int Ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Ans += water[i][j];
			}
		}
		System.out.println(Ans);
	}

	private static void move(int d, int s) {
		// 구름이 있던 칸 체크
		boolean[][] v = new boolean[N][N];

		// 구름 움직임
		int size = Q.size();
		for (int i = 0; i < size; i++) {
			Point p = Q.poll();

			int currentR = (p.r + dr[d] * s) % N;
			int currentC = (p.c + dc[d] * s) % N;

			if (currentR < 0)
				currentR = N + currentR;
			if (currentC < 0)
				currentC = N + currentC;

			water[currentR][currentC]++;
			v[currentR][currentC] = true;
			Q.add(new Point(currentR, currentC));
		}

		// 대각선(2,4,6,8) 물을 영향으로 증가
		for (int i = 0; i < size; i++) {
			Point p = Q.poll();

			for (int j = 2; j <= 8; j = j + 2) {
				int currentR = p.r + dr[j];
				int currentC = p.c + dc[j];

				if (currentR < 0 || currentR >= N || currentC < 0 || currentC >= N || water[currentR][currentC] < 1)
					continue;

				water[p.r][p.c]++;
			}
		}


		// 구름이 있던 칸을 제외하고 나머지 칸 중에서 물의 양이 2 이상인 칸에 구름이 생긴다. 구름이 생기면 물의 양이 2만큼 줄어든다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (water[i][j] >= 2 && !v[i][j]) {
					Q.add(new Point(i, j));
					water[i][j] = water[i][j] - 2;
				}
			}
		}
		
//		print();

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(water[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}
}

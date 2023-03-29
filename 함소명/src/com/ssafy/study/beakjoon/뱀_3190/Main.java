package com.ssafy.study.beakjoon.뱀_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Point[] apples;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 보드의 크기
		int[][] map = new int[N][N];

		K = Integer.parseInt(br.readLine());// 사과의 개수
		apples = new Point[K];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			apples[i] = new Point(r, c);
			map[r][c] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		Point[] move = new Point[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (!GameOver)
				moveSnack(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		if (!GameOver)
			move(cnt + N);

		System.out.println(cnt);
	}

	static int dir = 0;// D
	static int cnt;
	static boolean GameOver;
	static Point Current = new Point(1, 1);
	static Queue<Point> Q = new LinkedList<>();
	// 오,아,왼,위
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	private static void moveSnack(int totalCnt, String direction) {
		move(totalCnt);

		if (direction.equals("D")) {
			dir++;
		} else {
			dir = (--dir == -1) ? 3 : dir;
		}
		dir = dir % 4;

	}

	private static void move(int totalCnt) {

		while (true) {

			cnt++;
			Current.r = Current.r + dr[dir];
			Current.c = Current.c + dc[dir];


			// 벽을 만나면 죽음.
			if (Current.r > N || Current.r < 1 || Current.c > N || Current.c < 1) {
				GameOver = true;
				break;
			}


			// 자기 몸에 부딪히는지 확인
			for (Point point : Q) {
				if (point.r == Current.r && point.c == Current.c) {
					System.out.println("??????????");
					GameOver = true;
					cnt--;
					return;
				}
			}
			
			// 사과 먹으면 몸 길이 늘리기
			boolean eat = false;
			for (int i = 0; i < apples.length; i++) {
				if (apples[i].r == Current.r && apples[i].c == Current.c) {
					
					Q.offer(new Point(Current.r, Current.c));
					eat = true;
					apples[i].r = 0;
					apples[i].c = 0;
				}
			}

			// Queue 변경. 뱀 길이 이동
			if (!eat) {
				Q.poll();
				Q.offer(new Point(Current.r, Current.c));
			}

			// 움직인 시간이랑 같으면 다음으로 넘어감
			if (cnt == totalCnt) {
				break;
			}
		}

	}

}

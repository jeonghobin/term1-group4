package com.ssafy.study.beakjoon.뱀_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt, dir;
	static ArrayList<Point> apples;
	static boolean GameOver;
	static Queue<Point> Q = new LinkedList<>();
	// 오,아,왼,위
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

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
		apples = new ArrayList<>();
		Q.offer(new Point(1, 1));// 시작 위치

		int K = Integer.parseInt(br.readLine());// 사과의 개수
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			apples.add(new Point(r, c));
		}

		int L = Integer.parseInt(br.readLine());// 움직이는 방향
		int Ans = 0;
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (!GameOver)
				moveSnack(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		if (!GameOver)moveSnack(N, "");

		System.out.println(cnt);
	}

	private static void moveSnack(int totalCnt, String direction) {
		Point Current = Q.peek();
		L:while (true) {
			cnt++;
			int SnackSize = Q.size();
			for (int i = 0; i < SnackSize; i++) {
				Point p = Q.poll();
				Q.offer(p);
				if(i==SnackSize-1)
					Current = p;
			}
			
			int nr = Current.r + dr[dir];
			int nc = Current.c + dc[dir];

			// 0-1. 벽을 만나면 죽음.
			if (nr > N || nr < 1 || nc > N || nc < 1) {
				GameOver = true;
				break L;
			}

			// 0-2. 자기 몸에 부딪히면 죽음.
			for (Point p : Q) {
				if (p.r == nr && p.c == nc) {
					GameOver = true;
					break L;
				}
			}

			// 1. 먼저 뱀은 몸길이를 늘려 머리를 다음 칸에 위치 시킨다.
			Q.offer(new Point(nr, nc));
			
			// 2. 만약 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			boolean eat = false;
			for (int i = 0; i < apples.size(); i++) {
				if (apples.get(i).r == nr && apples.get(i).c == nc) {
					apples.remove(i);
					eat = true;
					break;
				}
			}
			
			// 3. 만약 사과가 없다면, 몸 길이를 줄여서 꼬리가 위치한 칸을 비워준다.
			if (!eat)
				Q.poll();
			
			if(cnt == totalCnt)
				break L;
		}

		// 방향바꾸기
		if (direction.equals("D")) {
			dir++;
		} else {
			dir = (--dir == -1) ? 3 : dir;
		}
		dir = dir % 4;
	}

}

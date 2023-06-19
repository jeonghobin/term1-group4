package com.ssafy.study.beakjoon.숨바꼭질_RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질3
public class Main_13549 {
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Queue<Point> Q = new LinkedList<>();
		// 한번 갔던건 다시 가지 않음. but 같은 길이라면 가야함.
		int[] v = new int[100001];
		// 시작 time을 1로 해놓고, 결과 출력시 1 빼기. visited의 값이 0인 것(방문 안한 곳)과 구별해주기 위해서.
		Q.add(new Point(N, 1));
		v[N] = 1;

		int cnt = Integer.MAX_VALUE;
		while (!Q.isEmpty()) {
			Point p = Q.poll();

//			 // 이렇게 쓰면 틀림
//			if (p.x == M) {
//				cnt = Math.min(cnt, p.cnt-1);
//				break;
//			}

			if (0 <= p.x + 1 && p.x + 1 <= 100000)
				if (v[p.x + 1] == 0 || v[p.x + 1] > p.cnt + 1) {
					v[p.x + 1] = p.cnt + 1;
					Q.add(new Point(p.x + 1, p.cnt + 1));
				}

			if (0 <= p.x - 1 && p.x - 1 <= 100000)
				if (v[p.x - 1] == 0 || v[p.x - 1] > p.cnt + 1) {
					v[p.x - 1] = p.cnt + 1;
					Q.add(new Point(p.x - 1, p.cnt + 1));
				}

			//같은것까지 넣어주면 무한로프가 돎.
			if (0 <= p.x * 2 && p.x * 2 <= 100000)
				if (v[p.x * 2] == 0 || v[p.x * 2] > p.cnt) {
					v[p.x * 2] = p.cnt;
					Q.add(new Point(p.x * 2, p.cnt));
				}
		}

		System.out.println(v[M]-1);
	}

	static class Point {
		int x, cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", cnt=" + cnt + "]";
		}
	}
}
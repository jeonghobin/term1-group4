package com.ssafy.study.beakjoon.마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.Queue;
import java.util.StringTokenizer;

//마법사 상어 파이어볼
public class Main {
	// 위,오위,오,오아,아,왼아,왼,왼위
	public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());// 파이어볼 개수
		K = Integer.parseInt(st.nextToken());// 명령 수

		Queue<Point> fireBall = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());// 질량
			int s = Integer.parseInt(st.nextToken());// 속록
			int d = Integer.parseInt(st.nextToken());// 방향

			// 1. 모든 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동
			fireBall.add(new Point(r, c, m, d, s));
		}

		int totalM = 0;
		for (int roll = 0; roll < K; roll++) {
			totalM = 0;
			ArrayList<ArrayList<Point>> list = new ArrayList<>();
//			System.out.println(fireBall);

			while (!fireBall.isEmpty()) {
				Point p = fireBall.poll();

				int nr = (N + p.r + dr[p.d] * (p.s % N)) % N;
				int nc = (N + p.c + dc[p.d] * (p.s % N)) % N;

				boolean duple = false;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).get(0).r == nr && list.get(i).get(0).c == nc) {
						list.get(i).add(new Point(nr, nc, p.m, p.d, p.s));
						duple = true;
						break;
					}
				}
				
				if (!duple) {
					ArrayList<Point> arr = new ArrayList<>();
					arr.add(new Point(nr, nc, p.m, p.d, p.s));
					list.add(arr);
				}
			}
//			System.out.println(list);
			// 2. 이동이 끝난뒤, 2개 이상의 파이어볼이 있는 칸에서는 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다
			// 2-2. 파이어볼은 4개의 파이어볼로 나누어진다.
			// 2-2-1. 질량 = ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다. ->질량 0이면 소멸된다.
			// 2-2-1. 속력 = ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
			// 2-2-1. 방향 = 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1,
			// 3, 5, 7이 된다.
			// 3. 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구하라.
			for (ArrayList<Point> arr : list) {
				int ballsize = arr.size();
				if(ballsize == 1) {
					fireBall.add(arr.get(0));
					totalM += arr.get(0).m;
				}else{
					int m = 0;
					int s = 0;
					//모두 홀수이거나 짝수일때
					boolean jjack = true;
					boolean hol = true;
					for (Point ball : arr) {
						m += ball.m;
						if (ball.d % 2 != 0) {
							jjack = false;
						}
						if (ball.d % 2 == 0) {
							hol = false;
						}
						s += ball.s;
					}
					m = m / 5;
					s = s / ballsize;

					// 질량 0인 파이어볼 소멸
					if (m == 0)
						continue;

					if ((!jjack&&hol)||(jjack&&!hol)) {
						for (int d = 0; d < 7; d = d + 2) {
							fireBall.add(new Point(arr.get(0).r, arr.get(0).c, m, d, s));
							totalM += m;
						}
					} else {
						for (int d = 1; d < 8; d = d + 2) {
							fireBall.add(new Point(arr.get(0).r, arr.get(0).c, m, d, s));
							totalM += m;
						}
					}
				}
			}
			
			if(totalM == 0) break;
			
		}

		System.out.println(totalM);

	}

	static class Point {
		int r, c, m, d, s;

		public Point(int r, int c, int m, int d, int s) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", m=" + m + ", d=" + d + ", s=" + s + "]";
		}

	}

}

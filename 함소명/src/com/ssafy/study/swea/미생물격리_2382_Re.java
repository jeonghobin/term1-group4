package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 미생물격리_2382_Re {
	static int N, M, K;
	static ArrayList<CELL> cell;

	// 상 하 좌 우
	static int[] dr = { 9, -1, 1, 0, 0 };
	static int[] dc = { 9, 0, 0, -1, 1 };

	static class CELL implements Comparable<CELL> {
		int h, w, n, m;

		public CELL(int h, int w, int n, int m) {
			super();
			this.h = h;
			this.w = w;
			this.n = n;
			this.m = m;
		}

		@Override
		public String toString() {
			return "CELL [h=" + h + ", w=" + w + ", n=" + n + ", m=" + m + "]";
		}

		@Override
		public int compareTo(CELL o) {
			int temp = this.h - o.h;// h좌표 오름차순 정렬
			if (temp == 0) {// 같으면
				temp = this.w - o.w;// w좌표 오름차순 정렬
				if (temp == 0)
					temp = o.n - this.n;// 미생물 개수 내림차순 정렬
			}
			return temp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 셀 개수
			M = Integer.parseInt(st.nextToken());// 격리시간
			K = Integer.parseInt(st.nextToken());// 미생물 군집 개수
			cell = new ArrayList<>();

//			System.out.println(N+", "+M+", "+K);
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());// 세로 위치
				int w = Integer.parseInt(st.nextToken());// 가로 위치
				int n = Integer.parseInt(st.nextToken());// 미생물 수
				int m = Integer.parseInt(st.nextToken());// 이동방향
				cell.add(new CELL(h, w, n, m));
			}

			int time = 0;
			while (time++ < M) {

				for (int i = 0; i < cell.size(); i++) {
					CELL c = cell.get(i);
					int cnt = c.n;
					int dir = c.m;

					// 방향으로 움직이기
					int nr = c.h + dr[dir];
					int nc = c.w + dc[dir];

//					// 같은 위치에 있으면 군집 합치기 -> 테케 2개 누락됨. 맨 나중에 군집합치기.
//					boolean isSum = false;
//					for (int j = 0; j < i; j++) {
//						if (cell.get(j).h == nr && cell.get(j).w == nc) {
//							if (cell.get(j).n > cnt) {
//								cell.set(j, new CELL(nr, nc, cnt + cell.get(j).n, cell.get(j).m));
//								cell.remove(i);
//								i--;
//								isSum = true;
//								break;
//							} else {
//								cnt = cnt + cell.get(j).n;
//								cell.remove(j);
//								i--;
//							}
//						}
//					}
//					if (!isSum) {
					// 약품에 닿으면 1. 방향 바꾸기, 2. 미생물 절반으로 줄이기
					if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
						// 방향 바꾸기
						if (dir % 2 == 0) // 짝수면 -1
							dir = dir - 1;
						else
							dir = dir + 1;// 홀수면
						// 절반 줄이기
						cnt = cnt / 2;
						if (cnt <= 0) {
							cell.remove(i);
							i--;
							continue;
						}
					}

					cell.set(i, new CELL(nr, nc, cnt, dir));
//					}
				}

				Collections.sort(cell);

				// 3. 이동한 후 한 셀에 2개 이상 미생물 군집이 있나?
				for (int num = 0; num < cell.size() - 1; num++) {
					// 좌표가 같을 때, 가장 앞에 있는 군집의 미생물 수가 가장 큼.
					CELL micro = cell.get(num); // 현재 미생물 군집 가져오기.
					CELL next = cell.get(num + 1); // 다음 미생물 군집 가져오기.
					if (micro.h == next.h && micro.w == next.w) {
						micro.n += next.n;
						cell.set(num, new CELL(micro.h, micro.w, micro.n, micro.m));// 내림차순정렬 군집에 미생물 수 합치기
						cell.remove(num + 1);// 미생물 군집에서 삭제
						num--;
						
					}
				}

			}

			int Ans = 0;
			for (CELL c : cell) {
				Ans += c.n;
			}
			System.out.println("#" + test_case + " " + Ans);
		}

	}

	private static void print() {
		int[][] map = new int[N][N];
		for (CELL c : cell) {
			map[c.h][c.w] = c.n;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

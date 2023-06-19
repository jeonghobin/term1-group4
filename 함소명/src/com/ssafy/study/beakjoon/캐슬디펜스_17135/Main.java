package com.ssafy.study.beakjoon.캐슬디펜스_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M, D, max = Integer.MIN_VALUE;
	static ArrayList<Point> enamy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		enamy = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enamy.add(new Point(i, j));
			}
		}

		// 조합//궁수를 놓을 자리 선정
		recursive(new int[3], 0, 0, new boolean[M]);
		System.out.println(max);
	}

	private static void recursive(int[] sel, int aIdx, int sIdx, boolean[] v) {
		if (sel.length == sIdx) {
//			System.out.println(Arrays.toString(sel));

			// 궁수의 공격으로 제거할 수 있는 적의 최대 수
			max = Math.max(max, attact(sel));

			return;
		}

		for (int i = aIdx; i < M; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = i;
				recursive(sel, i, sIdx + 1, v);
				v[i] = false;
			}
		}
	}

	private static int attact(int[] sel) {
		ArrayList<Point> tmp = new ArrayList<>();
		// 깊은복사
		for (int i = 0; i < enamy.size(); i++) {
			Point e = enamy.get(i);
			tmp.add(new Point(e.r, e.c));
		}
		// 죽는 병사수
		int cnt = 0;
		// 모든적을 죽여라
		while(tmp.size()>0) {
			ArrayList<Point> death = new ArrayList<>();
			// 궁수들이 적을 죽입니다
			for (int i = 0; i < 3; i++) {
				// i : 궁수
				int minD = Integer.MAX_VALUE;
				int minIdx = -1;
				int minC = M;
				for (int j = 0; j < tmp.size(); j++) {
					// j : 적군
					Point en = tmp.get(j);
					//  |r1-r2| + |c1-c2|
					int dist = Math.abs(N - en.r)+Math.abs(sel[i]-en.c);
					// 사정거리 안에 있고
					if(dist<=D) {
						// 가장 가까운놈
						if(minD>dist) {
							minD = dist;
							minIdx = j;
							minC = en.c;
						}else if(minD==dist) {
							// 거리가 같다면 왼쪽에 있는 놈
							if(en.c < minC) {
								minD=dist;
								minIdx=j;
								minC = en.c;
							}
						}
					}
				}
				// 죽일적군이 선택됬어요
				if(minIdx != -1) {
					death.add(tmp.get(minIdx));
				}
			}// 다음궁수
			// death 에 있는 병사를 삭제한다
			//System.out.println(death.size());
			//System.out.println(tmp.size());
			for (int i = 0; i < death.size(); i++) {
				for (int j = 0; j < tmp.size(); j++) {
					if(death.get(i)==tmp.get(j)) {
						tmp.remove(j--);
						cnt++;
					}
				}
			}
			//System.out.println(tmp.size());
//			// 적군이 1보 전진
			
			//System.out.println(cnt);
			
			for (int i = 0; i < tmp.size(); i++) {
				tmp.get(i).r++;
				if(tmp.get(i).r==N) {
					tmp.remove(i--);
				}
			}
		}
		return cnt;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
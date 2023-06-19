package com.ssafy.study.beakjoon.숨바꼭질_RE;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질
// 냄새는 1번 헛간에서의 거리(여기서 거리라 함은 지나야 하는 길의 최소 개수이다)가 멀어질수록 감소한다
public class Main_6118 {
	static int N, M;
	// 가장 멀리있는 헛간 중 가장 숫자가 작은 헛간 번호
	// 가장 멀리있는 헛간 길이
	// 가장 멀리있는 헛간 개수
	static int num,distance,cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 헛간의 개수
		M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] house = new ArrayList[N + 1];// 1~N
		for (int i = 1; i <= N; i++) {
			house[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			house[a].add(b);
			house[b].add(a);
		}

		Queue<Point> Q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];

		Q.add(new Point(1, 0));// 첫 시작
		v[1] = true;

		
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int now = p.num;
			int next = p.cnt;

			if (distance < next) {
				distance = next;
				num = now;
				cnt = 1;
			} else if (distance == next) {
				if (num > now)
					num = now;
				cnt++;
			}

			for (int i = 0; i < house[now].size(); i++) {
				int next_num = house[now].get(i);
				if (!v[next_num]) {
					v[next_num] = true;
					Q.add(new Point(next_num, next + 1));	
				}
			}
		}

		System.out.println(num + " " + distance + " " + cnt);
	}

	static class Point {
		int num, cnt;

		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", cnt=" + cnt + "]";
		}
	}
}

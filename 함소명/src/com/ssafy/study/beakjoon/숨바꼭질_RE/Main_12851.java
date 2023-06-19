package com.ssafy.study.beakjoon.숨바꼭질_RE;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851 {
	static int N, K, cnt, time;
	static int checkTime;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		BFS();
		System.out.println(time);
		System.out.println(cnt);
	}

	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		// 단순 visit처리가 아닌 거리도 체크해야 한다.
		int[] v = new int[100001];

		Q.add(new Point(N, 0));
		v[N] = 1;

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (p.num == K) {
				// 가장 빠른 시간
				if (cnt == 0) {
					time = p.cnt;
				}

				if (time == p.cnt) {
					cnt++;
				}
				continue;
			}

			int arr[] = { p.num + 1, p.num - 1, p.num * 2 };
			for (int i = 0; i < 3; i++) {
				int next = arr[i];

				if (next < 0 || next > 100000)
					continue;

				//이미 방문했더라도, 최단거리가 될 수 있는 경우라면 큐에 넣어줘야한다.
				if (v[next] == 0 || v[next] == p.cnt + 1) {
					v[next] = p.cnt+1;
					Q.add(new Point(next, p.cnt + 1));
				}
			}

		}

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

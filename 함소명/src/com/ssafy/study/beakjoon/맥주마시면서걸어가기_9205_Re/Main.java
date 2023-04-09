package com.ssafy.study.beakjoon.맥주마시면서걸어가기_9205_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다음 목적지까지 거리를 계산한다.
public class Main {
	static ArrayList<Integer>[] list;
	static ArrayList<Point> distance;
	static int[] dr = { 0, 0, -50, 50 };
	static int[] dc = { -50, 50, 0, 0 };

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
			int N = Integer.parseInt(br.readLine());// 맥주를 파는 편의점의 개수
			distance = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			distance.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				distance.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(br.readLine());
			distance.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

			// 인접리스트 생성 및 초기화
			list = new ArrayList[distance.size()];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			// 갈 수 있는 1000m 이하의 정점 모두 찾기
			for (int i = 0; i < distance.size(); i++) {
				for (int j = i+1; j < distance.size(); j++) {
					int r = Math.abs(distance.get(i).r - distance.get(j).r);
					int c = Math.abs(distance.get(i).c - distance.get(j).c);
					if (r + c <= 1000) {
						list[i].add(j);
						list[j].add(i);
					}
				}
			}
//			System.out.println(Arrays.toString(list));

			BFS();
		}
	}

	private static void BFS() {
		Queue<Integer> Q = new LinkedList<>();
		boolean[] v = new boolean[distance.size()]; 
		
		Q.add(0);
		
		String Ans = "sad";
		L:while (!Q.isEmpty()) {
			int idx = Q.poll();

			if(idx == distance.size()-1) {
				Ans = "happy";
				break L;
			}

			if(!v[idx]) {
				v[idx] = true;
				for (int i = 0; i < list[idx].size(); i++) {
					Q.offer(list[idx].get(i));
				}
			}
			
		}

		System.out.println(Ans);
	}

}

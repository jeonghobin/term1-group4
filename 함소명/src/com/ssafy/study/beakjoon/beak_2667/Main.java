package com.ssafy.study.beakjoon.beak_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//단지번호붙이기
//1은 집이 있는 곳을, 0은 집이 없는 곳
//연결된 집의 모임인 단지를 정의
//지도를 입력하여 단지수를 출력
//집의 수를 오름차순으로 정렬
public class Main {
	static int N;
	static int[][] map;
	static int total;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
	}

	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
		
	public static void bfs() {
		Queue<Point> Q = new LinkedList<Point>();
		boolean[][] v = new boolean[N][N];
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (map[i][j] == 1) {//1이 잡히면
					total++;
					v[i][j] = true;
					Q.offer(new Point(i, j,0));
					
					while (!Q.isEmpty()) {
						Point p = Q.poll();
						map[p.r][p.c] = 0;
						
						for (int k = 0; k < 4; k++) {
							int dr = p.r + dx[k]; 
							int dc = p.c + dy[k]; 
							
							if(dc>=0 && dc<N && dr>=0 && dr<N && !v[dr][dc] && map[dr][dc]==1) {
								v[dr][dc] = true;
								map[dr][dc] = 0;
								cnt++;
								Q.offer(new Point(dr,dc,p.cnt+1));
							}
						}
					}
					answer.add(cnt+1);
				}
			}
		}
		
		System.out.println(total);
		Collections.sort(answer);
		for (Integer i : answer) {
			System.out.println(i);
		}
		
	}
}

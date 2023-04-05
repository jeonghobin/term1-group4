package com.ssafy.study.beakjoon.맥주마시면서걸어가기_9205_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다음 목적지까지 거리를 계산한다.
public class Main {
	static int N,x,y,Ans,beer;
	static Point home,festival;
	static Point[] store;
	
	static int[] dr = {0,0,-50,50};
	static int[] dc = {-50,50,0,0};
	
	static class Point{
		int r,c;

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
			N = Integer.parseInt(br.readLine());// 맥주를 파는 편의점의 개수
			beer = 20;
            StringTokenizer st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < args.length; i++) {
            	st = new StringTokenizer(br.readLine());
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
            st = new StringTokenizer(br.readLine());
            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
            
            BFS();
			
		}

	}

	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(home);
		
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr>=-32768 && nc>=-32768 && nr<=32767 &&nc<=32767) {
					
					Q.add(new Point(nr, nc));
				}
			}
			
			
		}
		
	}

}

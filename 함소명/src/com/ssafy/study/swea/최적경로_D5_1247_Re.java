package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/***
 * 최적 경로
 * 
 * SSAFY N명의 고객을 모두 방문하고 자신의 집에 돌아가려한다.
 * 고객의 위치는 이차원 정수 좌표 (x, y) 거리는
 * |x1-x2| + |y1-y2|으로 계산 총 이동거리가 가장 짧은 경로
 *
 * 순열+DFS
 */
class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 최적경로_D5_1247_Re {

	static int Min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int Test_case = 1; Test_case <= T; Test_case++) {
			Min = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Position company = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Position home = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Position[] pos = new Position[N];
			for (int i = 0; i < N; i++) {
				pos[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			System.out.print("#" + Test_case + " ");
			DFS(pos, company, home, new Position[N], 0, new boolean[N]);
			System.out.println(Min);
		}
		
	}

	/**
	 * 
	 * @param pos : 고객들의 집 위치
	 * @param company : 회사 위치(출발)
	 * @param home : 집 위치(도착)
	 * @param sel : 담을 배열
	 * @param k : 인덱스
	 */
	
	public static void DFS(Position[] pos, Position company, Position home, Position[] sel, int k, boolean[] v) {
		if(k == sel.length) {
			k=0;
			int cul = Math.abs(company.x - sel[0].x)+Math.abs(company.y - sel[0].y);
			int doch = Math.abs(home.x - sel[sel.length-1].x)+Math.abs(home.y - sel[sel.length-1].y);

			int sum =0;
			for (int i = 0; i < sel.length-1; i++) {
				sum += Math.abs(sel[i].x - sel[i+1].x) + Math.abs(sel[i].y - sel[i+1].y);
			}
			Min = Math.min(sum+cul+doch, Min);
			
			return;
		}

		for (int i = 0; i < pos.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = pos[i];//[집1, -, -, -, -], [true,f,f,f,f]
				DFS(pos,company,home,sel,k+1,v);
				v[i] = false;
			}
		}
	}
}

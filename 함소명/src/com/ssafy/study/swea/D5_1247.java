package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.CORBA.PUBLIC_MEMBER;

/***
 * 최적 경로
 * 
 * SSAFY N명의 고객을 모두 방문하고 자신의 집에 돌아가려한다.
 * 고객의 위치는 이차원 정수 좌표 (x, y) 거리는
 * |x1-x2| + |y1-y2|으로 계산 총 이동거리가 가장 짧은 경로
 *
 * 순열
 */
class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class D5_1247 {

	static int T, Ans, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int Test_case = 0; Test_case < T; Test_case++) {
			int N = Integer.parseInt(br.readLine());
			Position[] cus = new Position[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Position[] ps = new Position[N];
			Position company = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Position home = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			
			for (int i = 0; i < N; i++) {
				cus[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			System.out.print("#" + Test_case + " ");
			DFS(cus, new Position[N], new boolean[N], 0, company, home);
		}
		
	}

	/**
	 * 
	 * @param cus[] : 고객 집 위치
	 * @param sel[] : 위치 잡기
	 * @param v[] : 백트래킹 막기
	 * @param k : 인덱스
	 * @param com : 회사 좌표
	 * @param home : 집 좌표
	 */
	public static void DFS(Position[] cus, Position[] sel, boolean[] v, int k, Position com, Position home) {

		if(k==sel.length) {
			//고객의 집 순서가 순열로 sel배열에 입력되었으니
			//회사에서 -번째 고객 방문
			//마지막 고객에서 집으로
			
			int c = Math.abs(com.x - cus[0].x)+Math.abs(com.y - cus[0].y);
			int h = Math.abs(sel[sel.length-1].x - home.x)+Math.abs(sel[sel.length-1].y - home.y);
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(sel[i].x - sel[i+1].x)+ Math.abs(sel[i].y - sel[i+1].y);
			}
			Ans = Math.min(Ans, c+h+sum);
			return;
		}
		
		for (int i = 0; i < cus.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = cus[i];
				DFS(cus, sel, v, k+1, com, home);
				v[i] = false;
			}
		}
		
	}
}
